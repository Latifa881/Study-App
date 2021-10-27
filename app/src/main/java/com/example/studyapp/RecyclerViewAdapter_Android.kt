package com.example.studyapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_review.view.*
import kotlinx.android.synthetic.main.edit_review.view.*
import kotlinx.android.synthetic.main.edit_review.view.cvLongDescription
import kotlinx.android.synthetic.main.edit_review.view.cvReviewTitle
import kotlinx.android.synthetic.main.edit_review.view.cvShortDescription
import kotlinx.android.synthetic.main.item_row.view.*


class RecyclerViewAdapter_Android(private val androidMaterials:ArrayList<AndroidMaterials>, var context:Context,val activity: AndroidReview_Activity):RecyclerView.Adapter<RecyclerViewAdapter_Android.ItemViewHolder>(){
    class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }
    val materialsDatabase by lazy {MaterialsDatabase.getInstance(context) }
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

        val data=androidMaterials[position]

        holder.itemView.apply {

            cvTitle.text=data.title
            cvDescription.text=data.shortDescription
            cvDescription.setOnClickListener {  customAlert(data.title,data.longDescription) }
            ivEdit.setOnClickListener {
                val builder = android.app.AlertDialog.Builder(context)
                val dialogView = LayoutInflater.from(context).inflate(R.layout.edit_review, null)
                val alertDialog: android.app.AlertDialog = builder.create()
                builder.setView(dialogView)
                dialogView.cvEdit.setOnClickListener {
                    val reviewTitle = dialogView.cvReviewTitle.text.toString()
                    val shortDecryption = dialogView.cvShortDescription.text.toString()
                    val longDecryption = dialogView.cvLongDescription.text.toString()
                    if (reviewTitle.isNotEmpty() && shortDecryption.isNotEmpty() && longDecryption.isNotEmpty()) {

                        materialsDatabase.materialsDao().updateAndroidReview(
                            AndroidMaterials(
                                0,
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
                ivDelete.setOnClickListener {
                    val builder = AlertDialog.Builder(context)
                    //set title for alert dialog
                    builder.setTitle("Delete a review")
                    //set message for alert dialog
                    builder.setMessage("Are you sure you want to delete this review?")
                    builder.setIcon(android.R.drawable.ic_dialog_info)

                    //performing positive action
                    builder.setPositiveButton("Delete") { dialogInterface, which ->
                        materialsDatabase.materialsDao().deleteAndroidReview(
                            AndroidMaterials(
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
    }

    override fun getItemCount()=androidMaterials.size
}