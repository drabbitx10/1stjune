package com.example.iteradmin.a1stjune

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val name = arrayOf("Ironman", "Cptain America", "Thor", "Hulk",
                           "Black Widow", "Hawkeye")
        val realname = arrayOf("Robert Downy Jr", "Chris Evans",
                               "Chris Hemsworth", "Mark Ruffalo", "Scarlet Jo", "Jeremy Renner")
        val images = arrayOf(R.drawable.iron_man, R.drawable.captain_america,
                             R.drawable.thor, R.drawable.hulk,
                             R.drawable.black_widow, R.drawable.barton
        )

        listView.adapter = MyAdapter(this, name, realname, images)

    }
    class MyAdapter(context:Context, n:Array<String>, realname:Array<String>, images:Array<Int>) : BaseAdapter() {

        private val mContex:Context

        private val name:Array<String>
        private val realname:Array<String>
        private  val  images:Array<Int>

        init {
            this.mContex = context
            this.name = n
            this.realname = realname
            this.images = images

        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layout:LayoutInflater = mContex.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootView = layout.inflate(R.layout.card, null, true)
            val im = rootView.findViewById<ImageView>(R.id.icon)
            val txt = rootView.findViewById<TextView>(R.id.title)
            val subtext = rootView.findViewById<TextView>(R.id.subtitle)

            im.setImageResource(images[position])
            txt.text = name[position]
            subtext.text = realname[position]

            return rootView

        }

        override fun getItem(position: Int): Any {
            return "anything"

        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return name.size
        }

    }
}
