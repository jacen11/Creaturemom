
package ru.dpastukhov.creaturemom.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.dpastukhov.creaturemom.model.Creature

@Dao
interface CreatureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creature: Creature)

    @Delete
    fun clearCreature(vararg creature: Creature)

    @Query("select * from creature_table order by name desc")
    fun getAllCreatures(): LiveData<List<Creature>>
}