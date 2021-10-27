package com.example.studyapp

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_review.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KotlinReview_Activity : AppCompatActivity() {
    var materials = arrayListOf<KotlinMaterials>()
    lateinit var myRV:RecyclerView
    val materialsDatabase by lazy {MaterialsDatabase.getInstance(applicationContext) }
    fun addToMaterialsArrayList() {
//        materials.add(Materials("Print a statement","The syntax of print() and println()",
//            " print()->Print with no line\n println()//Print with line\n"))
//        materials.add(Materials("Variables","Declare a variable (Can be changed mutable)",
//            " var number: Int = 5//Declaring and initializing a variable.\n" +
//                    "    var str:String //Declare a variable and specify a type.\n" +
//                    "    var name = \"Bob\"// Declaring variables and initializing without having to specify the data type (type inference).\n"))
//        materials.add(Materials("Constants","Declare a constant (Can't be changed immutable)","val a: Int = 5 //Declaring and initializing a constant.\n" +
//                "    val b = 5 //Declaring and initializing a constant (type inference).\n"))
//        materials.add(Materials("User Input","Get user input from keyboards","val userInput1 = readLine()//Read a string value.\n" +
//                "    val userInput2= readLine()!!//Ensure that the value of userInput2 will not be null(The user has entered a value).\n" +
//                "    val userInput3 = readLine()!!.toInt()//Convert userInput3 to integer\n"))
//        materials.add(Materials("String concatenation","Syntax of String concatenation","println(\"Hello\" + \"Sam\")   // --> HelloSam\n" +
//                "    val message = \"Hi there\"\n" +
//                "    val Name = \"Sam\"            //Using the variable/constant direct inside a print statement\n" +
//                "    println(message + Name)    // --> Hi thereSam\n"))
//        materials.add(Materials("String Interpolation","Syntax of String Interpolation","    val message2 = \"Hi there\"\n" +
//                "    val name2 = \"Sam\"              //Using \$ will give the value of the variable/constant\n" +
//                "    println(\"\$message2 \$name2\")    // --> Hi there Sam\n"))
//        materials.add(Materials("Data Types","Floats and Integers","        val numInt = 6     // -->6\n" +
//                "        val numFloat = 6f //  --> 6.0\n" +
//                "        val sum = numFloat + numInt // sum --> 12.0\n" +
//                "        Converting float into int\n" +
//                "        I can't add integer and float and save the result into int like this:\n" +
//                "        //val sum2=0\n" +
//                "        //sum2 = (numFloat + numInt).toInt()\n" +
//                "When converting down from float into int it will take the integer part only:\n" +
//                "        val num = 3.5 //println(num.toInt())  //  --> 3\n"))
//        materials.add(Materials("Basic Operations","Addition(+) ,Subtraction(-), Multiplication(*), Division(/), and the Modulo operator(%).","       Just change the sign:\n" +
//                "        var num3=0\n" +
//                "            num3++// increment by 1\n" +
//                "            num3=num3+1 //increment by 1\n" +
//                "            num3=num3+1 //increment by 1\n" +
//                "         // **->Avoid dividing by zero, as it would lead to a crash.\n" +
//                "        var num4 = 10 / 0  //  --> Zero Division Error\n"))
//        materials.add(Materials("If Statements","Syntax of It Statements","//if ( condition1){}\n" +
//                "        //else if (condition2){}\n" +
//                "        //else{}\n"))
//        materials.add(Materials("Try/Catch","Syntax of Try/Catch"," try {\n" +
//                "           //Write the code here\n" +
//                "        } catch (e: Exception) {\n" +
//                "            println(e.toString())\n" +
//                "        }\n"))
//        materials.add(Materials("Loops","For and While loops"," for loop\n" +
//                "        for(number in 1..5){// number here is an index\n" +
//                "            println(number)\n" +
//                "        }\n" +
//                "        val msg2=\"Latifa\"\n" +
//                "        for(letter in msg2){\n" +
//                "            println(letter)}\n" +
//                "        /while loop\n" +
//                "        var count = 0\n" +
//                "        while (count < 5){\n" +
//                "            count ++\n" +
//                "            println(count)\n" +
//                "        }\n"))
//        materials.add(Materials("When","Used when we have series of if statements","            //    when {\n" +
//                "        //        codition1 -> {then part}\n" +
//                "        //        codition2 -> {then part}\n" +
//                "        //        codition3 -> {then part}\n" +
//                "        //        else->{}\n" +
//                "        //    }\n"))
//        materials.add(Materials("Import Random Module","Random.nextInt(from,excluded)","val randomNumber1 = Random.nextInt(11)//from 0 to 10\n" +
//                "    val randomNumber2 = Random.nextInt(2,7)//from 2 to 6\n"))
//        materials.add(Materials("Functions","Function Syntax","Create a function:\n" +
//                "fun functionName(){}\n" +
//                "Create a function with parameter:\n" +
//                "fun functionName(variable:Type){}\n" +
//                "Create a function with parameter and return value\n" +
//                "fun functionName(variable:Type):Type{\n" +
//                "return Type}\n" +
//                "Example:\n" +
//                "fun main(){\n" +
//                "fun f1(){println(“Inside f1”)}\n" +
//                "fun f1(str:String){println(“Your name is \$str”)}\n" +
//                "fun f3(str:String):Int{return str.toInt()}\n" +
//                "f1()\n" +
//                "f2(“Latifa”)\n" +
//                "print(“30”)\n" +
//                "}\n" +
//                "Output:\n" +
//                "Inside f1\n" +
//                "Your name is Latifa\n" +
//                "30\n"))
//        materials.add(Materials("Lists and Arrays","List \uF0E0 listOf(value,value) // Lists are immutable. Once we create a List, we cannot make any changes to it.\n" +
//                "Array \uF0E0arrayOf(value,value) // Arrays are mutable. We can change each item at any time.\n","Both Lists and Arrays have fixed sizes!!\n" +
//                "In order to add additional items, we need to use ArrayLists. \n" +
//                "Arrays and Lists can hold more than one data type at a time.\n" +
//                "change values inside of a List \uF0E0would cause an error.\n" +
//                "Example:\n" +
//                "fun main(){\n" +
//                "val myList=listOf(“Car”, 15, false, 19, “Bike”)\n" +
//                "val myArray=arrayOf(“Car”, 15, false, 19, “Bike”)\n" +
//                "val myArray2= arrayOf(“B”, “B”, “C”)\n" +
//                "println(myList[4])\n" +
//                "println(myArray[2])\n" +
//                "println(myArray2[2])\n" +
//                "//myList[0]=”Boat” \uF0E0 //Unresolved reference error \n" +
//                "myArray2[0]=”A”\n" +
//                "print(myArray2[0])\n" +
//                "println(myList.size)\n" +
//                "println(myArray2.size)\n" +
//                "}\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "Output: \n" +
//                "Bike\n" +
//                "false\n" +
//                "C\n" +
//                "A5\n" +
//                "3\n"))
//        materials.add(Materials("ArrayLists","ArrayLists -->Don’t have a fixed size. We can add and remove items at will and make changes to each item.","Example:\n" +
//                "fun main(){\n" +
//                "    val shoppingList = ArrayList()\n" +
//                "    shoppingList.add(\"Eggs\")\n" +
//                "    shoppingList.add(\"Bread\")\n" +
//                "    shoppingList.add(\"Milk\")\n" +
//                "    shoppingList.add(\"Bananas\")\n" +
//                "    shoppingList[0] = \"Butter\"\n" +
//                "    shoppingList.remove(\"Milk\")\n" +
//                "    shoppingList.add(\"Apples\")\n" +
//                "    for(item in shoppingList){\n" +
//                "    \tprintln(item)\n" +
//                "    }\n" +
//                "}\n" +
//                "Output: \n" +
//                "Butter\n" +
//                "Bread\n" +
//                "Bananas\n" +
//                "Apples\n"))
//        materials.add(Materials("2D ArrayLists","Create a 2D arrayList:\n" +
//                "arrayListOf( arrayListOf <Type>() )\n" +
//                "Add to the arrayList:\n" +
//                ".add(arrayListOf())\n","Example:\n" +
//                "fun main(){\n" +
//                "    val countries = arrayListOf(arrayListOf<String>())\n" +
//                "\n" +
//                "    for(i in 0..2){\n" +
//                "        var country = \"\"\n" +
//                "        var capital = \"\"\n" +
//                "\n" +
//                "        print(\"Enter a country: \")\n" +
//                "        country = readLine()!!\n" +
//                "        print(\"Enter the capital: \")\n" +
//                "        capital = readLine()!!\n" +
//                "\n" +
//                "        countries.add(arrayListOf(country, capital))\n" +
//                "    }\n" +
//                "\n" +
//                "    for(i in countries){\n" +
//                "        if(i.isNotEmpty()){\n" +
//                "            println(\"The capital of \${i[0]} is \${i[1]}.\")\n" +
//                "        }\n" +
//                "    }\n" +
//                "}\n"))
//        materials.add(Materials("Dictionaries","Dictionaries are called\uF0E0 Maps \n" +
//                "A Map creates a unique key for each value.\n" +
//                "mapOf()\n","If we want to make sure that our Map query returns a value, we can provide a default using\uF0E0 .getOrDefault(key, default value) \n" +
//                "To check if a key is present in our Map\uF0E0 .containsKey(key) We cannot We cannot add additional key value pairs to our Map. In order to add more pairs, we need to use a MutableMap.\n" +
//                "Example:\n" +
//                "fun main(){\n" +
//                "val dic=mapOf(1 to “Latifa”, 2 to “Sara”)\n" +
//                "print(dic[1]+” “ +dic[2])\n" +
//                "println(dic.getOrDefault(0, \"My Default Name\"))  \n" +
//                "println(dic.containsKey(1))  \n" +
//                "println(seats.containsValue(\"Bob\"))  \n" +
//                "val seats = mutableMapOf(1 to \"Sara\", 2 to \"Jim\", 3 to \"Jane\")\n" +
//                "println(seats[2])  // --> Jim\n" +
//                "println(seats[0])  // --> null\n" +
//                "seats[0] = \"Fred\"\n" +
//                "println(seats[0])  // --> Fred\n" +
//                "Output:\n" +
//                "Sara nullMy Default Name\n" +
//                "true\n" +
//                "false\n" +
//                "Jim nullFred \n"))
//        materials.add(Materials("OOP in Kotlin","Create a class:\n" +
//                "class className :superclass(){\n" +
//                "init{}//constructer \n" +
//                "}\n","    abstract class Vehicle{\n" +
//                "        var color = \"Blue\"\n" +
//                "        abstract fun doors()\n" +
//                "    }\n" +
//                "    class FamilyCar: Vehicle(){\n" +
//                "        override fun doors() {\n" +
//                "            println(\"This car has 4 doors\")\n" +
//                "        }\n" +
//                "    }\n" +
//                "    class SportsCar: Vehicle(){\n" +
//                "        override fun doors() {\n" +
//                "            println(\"This car has 2 doors\")\n" +
//                "        }\n" +
//                "    }\n" +
//                "    FamilyCar().doors()  // --> This car has 4 doors\n" +
//                "    println(\"The family car is \${FamilyCar().color}.\")  // --> The family car is Blue.\n" +
//                "    val mySportsCar = SportsCar()\n" +
//                "    mySportsCar.doors()  // --> This car has 2 doors\n" +
//                "    mySportsCar.color = \"Red\"\n" +
//                "    println(\"The color of my sports car is \${mySportsCar.color}.\")  // --> The color of my sports car is Red.\n" +
//                "\n"))
//
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_review)


        //RecyclerView
        myRV = findViewById(R.id.rvMain)
        myRV.adapter = RecyclerViewAdapter_Kotlin(materials, this,this)
        myRV.layoutManager = LinearLayoutManager(this)
        readFromDB()
        getSupportActionBar()?.setTitle("Kotlin Review")

    }

    //Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 0, 0, "Menu")?.setIcon(R.drawable.note_book)
            ?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> {
                val builder = AlertDialog.Builder(this)
                val dialogView = LayoutInflater.from(this).inflate(R.layout.add_review, null)

                builder.setView(dialogView)
                val alertDialog: AlertDialog = builder.create()
                dialogView.cvAdd.setOnClickListener {
                    val reviewTitle = dialogView.cvReviewTitle.text.toString()
                    val shortDecryption = dialogView.cvShortDescription.text.toString()
                    val longDecryption = dialogView.cvLongDescription.text.toString()
                    if (reviewTitle.isNotEmpty() && shortDecryption.isNotEmpty() && longDecryption.isNotEmpty()) {

                        materialsDatabase.materialsDao().insertKotlinReview(KotlinMaterials(0,reviewTitle,shortDecryption,longDecryption))
                        Toast.makeText(this,"The review is added successfully! ",Toast.LENGTH_SHORT).show()
                        readFromDB()
                        alertDialog.dismiss()

                    }else{
                        Toast.makeText(this,"Enter all the information! ",Toast.LENGTH_SHORT).show()
                    }
                }


                alertDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                alertDialog.setCancelable(true)
                alertDialog.show()
            }
            R.id.KotlinReview -> {
                var intent = Intent(this, KotlinReview_Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.AndroidReview -> {
                var intent = Intent(this, AndroidReview_Activity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun readFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            materials.clear()
            materials.addAll(
                materialsDatabase.materialsDao().getKotlinMaterials()
            )
            withContext(Dispatchers.Main) {
                myRV.adapter!!.notifyDataSetChanged()
            }
        }

    }
}