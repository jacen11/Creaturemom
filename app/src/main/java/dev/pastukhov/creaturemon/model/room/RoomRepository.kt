package dev.pastukhov.creaturemon.model.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import dev.pastukhov.creaturemon.app.CreaturemonApplication
import dev.pastukhov.creaturemon.model.Creature
import dev.pastukhov.creaturemon.model.CreatureRepository

class RoomRepository : CreatureRepository {
    private val creatureDao: CreatureDao = CreaturemonApplication.database.creatureDao()

    private val allCreatures: LiveData<List<Creature>>

    init {
        allCreatures = creatureDao.getAllCreatures()
    }

    private class InsertAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.clearCreatures(*params)
            return null
        }
    }

    override fun saveCreature(creature: Creature) {
        InsertAsyncTask(creatureDao).execute(creature)
    }

    override fun getAllCreatures() = allCreatures

    override fun clearAllCreatures() {
        val creatureArray = allCreatures.value?.toTypedArray()
        creatureArray?.let { DeleteAsyncTask(creatureDao).execute(*creatureArray) }
    }
}