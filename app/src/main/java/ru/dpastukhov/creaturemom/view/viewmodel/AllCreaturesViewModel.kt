package ru.dpastukhov.creaturemom.view.viewmodel

import androidx.lifecycle.ViewModel
import ru.dpastukhov.creaturemom.model.CreatureRepository
import ru.dpastukhov.creaturemom.model.room.RoomRepository

class AllCreaturesViewModel(private val repository: CreatureRepository = RoomRepository()) : ViewModel() {

    private val allCreaturesLiveData = repository.getAllCreatures()

    fun getAllCreaturesLiveData() = allCreaturesLiveData

    fun clearAllCreatures() = repository.clearAllCreatures()
}