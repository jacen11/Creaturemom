package dev.pastukhov.creaturemon.view.allcreatures

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_creature.view.*
import kotlinx.android.synthetic.main.list_item_creature.view.hitPoints
import dev.pastukhov.creaturemon.app.inflate
import dev.pastukhov.creaturemon.R
import dev.pastukhov.creaturemon.model.Creature

class CreatureAdapter(private val creatures: MutableList<Creature>) : RecyclerView.Adapter<CreatureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_creature))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(creatures[position])
    }

    override fun getItemCount() = creatures.size

    fun updateCreatures(creatures: List<Creature>) {
        this.creatures.clear()
        this.creatures.addAll(creatures)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var creature: Creature

        fun bind(creature: Creature) {
            this.creature = creature
            val bitmap = BitmapFactory.decodeResource(itemView.context.resources, creature.drawable)
            itemView.avatarListItem.setImageDrawable(BitmapDrawable(itemView.context.resources, bitmap))
            itemView.name.text = creature.name
            itemView.hitPoints.text = creature.hitPoints.toString()
        }
    }
}
