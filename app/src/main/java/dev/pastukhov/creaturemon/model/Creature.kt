
package dev.pastukhov.creaturemon.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "creature_table")
data class Creature(
        val attributes: CreatureAttributes = CreatureAttributes(),
        val hitPoints: Int = 0,
        //TODO ключ на айдишник переделать
        @PrimaryKey @NonNull val name: String,
        val drawable: Int = 0
)