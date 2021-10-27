package com.example.studyapp


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_review.view.*
import kotlinx.android.synthetic.main.add_review.view.cvLongDescription
import kotlinx.android.synthetic.main.add_review.view.cvReviewTitle
import kotlinx.android.synthetic.main.add_review.view.cvShortDescription
import kotlinx.android.synthetic.main.edit_review.view.*
import kotlinx.android.synthetic.main.item_row.view.*


class RecyclerViewAdapter_Kotlin(
    private val kotlinMaterials: ArrayList<KotlinMaterials>,
    val context: Context,
    val activity: KotlinReview_Activity
) : RecyclerView.Adapter<RecyclerViewAdapter_Kotlin.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    val materialsDatabase by lazy { MaterialsDatabase.getInstance(context) }
    fun customAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(context)
        //set title for alert dialog
        builder.setTitle(title)
        //set message for alert dialog
        builder.setMessage(message)
        builder.setIcon(android.R.drawable.ic_dialog_info)

        //performing positive action
        builder.setPositiveButton("Ok") { dialogInterface, which ->
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val data = kotlinMaterials[position]

        holder.itemView.apply {

            cvTitle.text = data.title
            cvDescription.text = data.shortDescription
            cvDescription.setOnClickListener { customAlert(data.title, data.longDescription) }
            ivEdit.setOnClickListener {
                val builder = android.app.AlertDialog.Builder(context)
                val dialogView = LayoutInflater.from(context).inflate(R.layout.edit_review, null)
                builder.setView(dialogView)
                val alertDialog: android.app.AlertDialog = builder.create()
                dialogView.cvReviewTitle.setText(data.title)
                dialogView.cvShortDescription.setText(data.shortDescription)
                dialogView.cvLongDescription.setText(data.longDescription)

                dialogView.cvEdit.setOnClickListener {
                    val reviewTitle = dialogView.cvReviewTitle.text.toString()
                    val shortDecryption = dialogView.cvShortDescription.text.toString()
                    val longDecryption = dialogView.cvLongDescription.text.toString()
                    if (reviewTitle.isNotEmpty() && shortDecryption.isNotEmpty() && longDecryption.isNotEmpty()) {

                        materialsDatabase.materialsDao().updateKotlinReview(
                            KotlinMaterials(
                                data.id,
                                reviewTitle,
                                shortDecryption,
                                longDecryption
                            )
                        )
                        Toast.makeText(
                            context,
                            "The review is updated successfully! ",
                            Toast.LENGTH_SHORT
                        ).show()
                        activity.readFromDB()
                        alertDialog.dismiss()
                    } else {
                        Toast.makeText(context, "Enter all the information! ", Toast.LENGTH_SHORT)
                            .show()
                    }
                    activity.readFromDB()
                }
                dialogView.cvCancel.setOnClickListener {
                    alertDialog.cancel()
                }
                // Set other dialog properties
                alertDialog.setCancelable(true)
                alertDialog.show()
            }
            ivDelete.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                //set title for alert dialog
                builder.setTitle("Delete a review")
                //set message for alert dialog
                builder.setMessage("Are you sure you want to delete this review?")
                builder.setIcon(android.R.drawable.ic_dialog_info)

                //performing positive action
                builder.setPositiveButton("Delete") { dialogInterface, which ->
                    materialsDatabase.materialsDao().deleteKotlinReview(
                        KotlinMaterials(
                            data.id,
                            data.title,
                            data.shortDescription,
                            data.longDescription
                        )
                    )
                    activity.readFromDB()
                }
                builder.setNegativeButton("Cancel") { dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
            }


        }
    }

    override fun getItemCount() = kotlinMaterials.size
}
