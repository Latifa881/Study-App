package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AndroidReview_Activity : AppCompatActivity() {
    var materials = arrayListOf<Materials>()
    fun addToMaterialsArrayList(){
        materials.add(Materials("Project Overview","Project Overview Description","app\n" +
                "\tmanifest //The manifest file allows us to get functionality such as GPS, internet connection etc.\n" +
                "\tjava //We have 3sub-folders under the java folder. The first one is where we write our code and the rest is for testing\n" +
                "\tres //The resources folder\n" +
                "\t\tdrawable //Here we save/store pictures in Android Studio project\n" +
                "\t\tlayout //Under this folder we can see the XML files (UI Design)\n" +
                "\t\tmipmap\n" +
                "\t\tvalues\n" +
                "\t\t\tcolors //We can specify colors by defining a name and use this name in the project instead of defining its Hexa number. \n" +
                "\t\t\tStrings //We can specify strings by defining a name and use this name in the project instead of defining a string. This could be helpful when you need to change a string that has been used multiple times and maybe in different places across the project.\n" +
                "\t\t\tThemes //Here we can change the look of our application. We can remove the action-bar from the application by changing .DarkActionBar  into .NoActionBar\n" +
                "<resources xmlns:tools=\"http://schemas.android.com/tools\">\n" +
                "<style name=\"Theme.HelloWorldApp2\" parent=\"Theme.MaterialComponents.DayNight.DarkActionBar\">\n" +
                "</style>\n" +
                "</resources>\n"))
        materials.add(Materials("Using the Console","We can use println() in the console","Once we launch our application, we can use the console to print information while we develop our app. Anything that prints to the console will be invisible to the end-user.\n" +
                "println()\n" +
                "Log.D(tag,message)\n"))
        materials.add(Materials("Resource Files","It is important to keep in mind that the color names in the base file are used across the app. If you choose to make changes to the names of these colors, you should use the 'refractor' tool.","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<resources>\n" +
                "    <color name=\"purple_200\">#FFBB86FC</color> //If you want to change the name of the color and to make sure that the new name is used --> right click on the name --> refactor --> rename\n" +
                "</resources>\n"))
        materials.add(Materials("Useful Attributes ","Useful Attributes for UI Widgets","android:textSize=\"20dp\"//change the size of the text\n" +
                "android:textAlignment=\"center\"//change the alignment of the text \n" +
                "  android:weightSum=\"2\"//if you want to divide a layout for example into 2 equal parts.\n" +
                "android:layout_weight=\"1\"//use this attributes to specify the space\n" +
                "android:gravity=\"center\"//change text position/alignment inside the widget\n" +
                "android:layout_gravity=\"right\"//change the widget position/alignment\n" +
                "android:textStyle=\"italic\"//change the text style Bold, italic..\n" +
                "android:backgroundTint=\"@color/black\"//change the background color\n" +
                "android:background=\"@drawable/image_logo\"//change the background image\n" +
                "android:id=\"@+id/textView\"//define an ID for the widget \n"))
        materials.add(Materials("Initializing UI Elements","How to initialize UI elements","Button bt1=findViewById<Button>(R.id.buton1)//initializing UI element inside a function like onCreae()\n" +
                "lateinit var name:TextView //We use lateinit if we want the UI element be used across the file and not tied to a function (not a local variable)\n" +
                "name=findVewById(R.id.nameID)\n" +
                "name.text=”Latifa”//change the text of name UI\n"))
        materials.add(Materials("OnClickListener","Adding action to UI elements","Before we can create an OnClickListener, we will need a button. Create a button with a unique id and initialize it in the onCreate method.\n" +
                "Once your button is initialized, we can add an OnClickListener with the following code:\n" +
                "myButton.setOnClickListener { myFuction() }//this is the easiest way to use setOnClickListener\n" +
                "   myButton.setOnClickListener(View.OnClickListener { myFuction() })//another way to use setOnClickListener\n" +
                "Don't forget to replace 'myFunction' with the name of your function.\n"))
        materials.add(Materials("Snackbar","We can use a Snackbar to display alerts in our application. Use the following code to create a Snackbar.","var myLayout = findViewById<LayoutType>(R.id.clID)//specify where your snackbar will ahow\n" +
                "Snackbar.make(myLayout, “Your message” ,Snackbar.LENGTH_SHORT).show()//the last argument can have different values sush as LENGTH_INDEFINITE, LENGTH_LONG\n"))
        materials.add(Materials("Recycler View","RecyclerView is the ViewGroup that contains the views corresponding to your data. It's a view itself, so you add RecyclerView into your layout the way you would add any other UI element. ... After the view holder is created, the RecyclerView binds it to its data. You define the view holder by extending RecyclerView.","To use the RecyclerView you need to prepare the following:\n" +
                "•\tThe layout to be used in the RecyclerView.\n" +
                "•\tThe recycler view layout in the Main Activity. \n" +
                "•\tCreate a RecyclerViewAdapter class:\n" +
                "o\tExtends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> class \n" +
                "o\tOverrides onCreateViewHolder, onBindViewHolder and getItemCount()\n" +
                "Example: \n" +
                "class RecyclerViewAdapter(private val guessText:ArrayList<String>):RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){\n" +
                "    class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) { }\n" +
                "    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {\n" +
                "        return ItemViewHolder(\n" +
                "            LayoutInflater.from(parent.context).inflate(\n" +
                "                R.layout.item_row,\n" +
                "                parent,\n" +
                "                false\n" +
                "            )\n" +
                "        )\n" +
                "    }\n" +
                "    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {\n" +
                "        val text=guessText[position]\n" +
                "        holder.itemView.apply {\n" +
                "            tvText.text=text\n" +
                "        }\n" +
                "    }\n" +
                "    override fun getItemCount()=guessText.size\n" +
                "}\n" +
                "•\tUse the RecyclerView in the Main Activity:\n" +
                "Example:\n" +
                "lateinit var myRV: RecyclerView\n" +
                "  \t\t     myRV = findViewById(R.id.rvMain)\n" +
                "   \t\t     myRV.adapter = RecyclerViewAdapter(arrayListName)\n" +
                "                 myRV.layoutManager = LinearLayoutManager(this)\n" +
                "\n" +
                "   \t     myRV.adapter!!.notifyDataSetChanged()//to update the recycler view\n"))
        materials.add(Materials("Alert Dialogs","It’s better to create a function when using an alert dialog rather than to re-write the code again.","fun customAlert(title: String, message: String) {\n" +
                "        val builder = AlertDialog.Builder(this)\n" +
                "        //set title for alert dialog\n" +
                "        builder.setTitle(title)\n" +
                "        //set message for alert dialog\n" +
                "        builder.setMessage(message)\n" +
                "        builder.setIcon(android.R.drawable.ic_dialog_info)\n" +
                "        //performing positive action\n" +
                "        builder.setPositiveButton(\"Ok\") { dialogInterface, which ->\n" +
                "        }\n" +
                "        // Create the AlertDialog\n" +
                "        val alertDialog: AlertDialog = builder.create()\n" +
                "        // Set other dialog properties\n" +
                "        alertDialog.setCancelable(false)\n" +
                "        alertDialog.show()\n" +
                "    }\n"))
        materials.add(Materials("Basic Control Flow ","Recreate Activity","Rotating our device destroys our main activity and recreates is.  \n" +
                "If we ever want to recreate our main activity manually, we can use this.recreate()\n"))
        materials.add(Materials("Saving / Restoring Instance States","Saving and restoring instances allows us to enable screen rotation without having to worry about losing data.",".In this example, we are assuming two variables exist; an integer called someNumber, and a string called myMessage.\n" +
                "\n" +
                "To save our instance we need to override the onSaveInstanceState method. Add the following code under the onCreate method.\n" +
                "\n" +
                "    override fun onSaveInstanceState(outState: Bundle) {\n" +
                "        super.onSaveInstanceState(outState)\n" +
                "        outState.putInt(\"myNumber\", someNumber)\n" +
                "        outState.putStringArrayList(\"myMessage\", myMessage)\n" +
                "    }        \n" +
                "In order to restore our instance we override the onRestoreInstanceState.\n" +
                "\n" +
                "    override fun onRestoreInstanceState(savedInstanceState: Bundle) {\n" +
                "        super.onRestoreInstanceState(savedInstanceState)\n" +
                "        someNumber= savedInstanceState.getInt(\"myNumber\", 0)\n" +
                "        myMessage = savedInstanceState.getString(\"myMessage\", \"No Message\")\n" +
                "    }        \n" +
                "Try adding this feature to one of your previous applications in order to preserve the state of your application even if the user rotates their device.\n"))
        materials.add(Materials("Shared Preferences","Shared Preferences allow us to save data to the user's device\n" +
                "\n","private lateinit var sharedPreferences: SharedPreferences// to use the shared preferences we need to declare our Shared Preferences variable.\n" +
                "Once we initialize Shared Preferences, we can load and save data.But before we do that, let's add the following line to our strings.xml file.\n" +
                "\n" +
                "<string name=\"preference_file_key\">com.example.helloworld.PREFERENCE_FILE_KEY</string>\n" +
                "Now we can refer to the Shared Preferences string.\n" +
                "\n" +
                "sharedPreferences = this.getSharedPreferences(\n" +
                "\tgetString(R.string.preference_file_key), Context.MODE_PRIVATE)\n" +
                "myMessage = sharedPreferences.getString(\"myMessage\", \"\").toString()  // --> retrieves data from Shared Preferences\n" +
                "// We can save data with the following code\n" +
                "with(sharedPreferences.edit()) {\n" +
                "    putString(\"myMessage\", myMessage)\n" +
                "    apply()\n" +
                "}\n"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_review)

        addToMaterialsArrayList()

        //RecyclerView
        val myRV = findViewById<RecyclerView>(R.id.rvMain)
        myRV.adapter = RecyclerViewAdapter(materials,this)
        myRV.layoutManager = LinearLayoutManager(this)

    }
    //Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.KotlinReview -> {
                var intent= Intent(this,KotlinReview_Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.AndroidReview -> {
                var intent= Intent(this,AndroidReview_Activity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}