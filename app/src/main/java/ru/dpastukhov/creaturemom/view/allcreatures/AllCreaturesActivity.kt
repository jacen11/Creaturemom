package ru.dpastukhov.creaturemom.view.allcreatures

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_all_creatures.*
import kotlinx.android.synthetic.main.content_all_creatures.*
import ru.dpastukhov.creaturemom.R
import ru.dpastukhov.creaturemom.view.creature.CreatureActivity
import ru.dpastukhov.creaturemom.view.viewmodel.AllCreaturesViewModel

class AllCreaturesActivity : AppCompatActivity() {

    private lateinit var viewModel: AllCreaturesViewModel

    private val adapter = CreatureAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_creatures)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProvider(this).get(AllCreaturesViewModel::class.java)

        creaturesRecyclerView.layoutManager = LinearLayoutManager(this)
        creaturesRecyclerView.adapter = adapter

        viewModel.getAllCreaturesLiveData().observe(this, Observer { creatures ->
            creatures?.let { adapter.updateCreatures(creatures) }
        })

        fab.setOnClickListener {
            startActivity(Intent(this, CreatureActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_all -> {
                viewModel.clearAllCreatures()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
