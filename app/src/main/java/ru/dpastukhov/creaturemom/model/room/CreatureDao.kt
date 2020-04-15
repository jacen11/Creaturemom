
package ru.dpastukhov.creaturemom.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.dpastukhov.creaturemom.model.Creature

@Dao
interface CreatureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creature: Creature)

    @Delete
    fun clearCreatures(vararg creature: Creature)

    @Query("SELECT * FROM creature_table ORDER BY name ASC")
    fun getAllCreatures(): LiveData<List<Creature>>
}