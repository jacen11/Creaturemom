package dev.pastukhov.creaturemon.view.viewmodel

import androidx.lifecycle.ViewModel
import dev.pastukhov.creaturemon.model.CreatureRepository
import dev.pastukhov.creaturemon.model.room.RoomRepository

class AllCreaturesViewModel(private val repository: CreatureRepository = RoomRepository()) : ViewModel() {

    private val allCreaturesLiveData = repository.getAllCreatures()

    fun getAllCreaturesLiveData() = allCreaturesLiveData

    fun clearAllCreatures() = repository.clearAllCreatures()
}