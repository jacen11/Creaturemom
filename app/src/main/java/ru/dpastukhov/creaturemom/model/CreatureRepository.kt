
package ru.dpastukhov.creaturemom.model

import androidx.lifecycle.LiveData

interface CreatureRepository{
    fun saveCreature(creature: Creature)
    fun getAllCreatures(): LiveData<List<Creature>>
    fun clearAllCreatures()
}