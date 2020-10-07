package ru.dpastukhov.creaturemom.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dpastukhov.creaturemom.model.*
import ru.dpastukhov.creaturemom.model.room.RoomRepository

class CreatureViewModel(
    private val generator: CreatureGenerator = CreatureGenerator(),
    private val repository: CreatureRepository = RoomRepository()
) : ViewModel() {

    private val creatureLiveData = MutableLiveData<Creature>()

    fun getCreatureLiveData(): LiveData<Creature> = creatureLiveData
    var name = ""
    var intelligence = 0
    var strength = 0
    var endurance = 0
    var drawable = 0

    lateinit var creature: Creature

    fun updateCreature() {
        val attributes = CreatureAttributes(intelligence, strength, endurance)
        creature = generator.generateCreature(attributes, name, drawable)
        creatureLiveData.postValue(creature)
    }

    fun attributeSelected(attributeType: AttributeType, position: Int) {
        when (attributeType) {
            AttributeType.INTELLIGENCE -> intelligence = AttributeStore.INTELLIGENCE[position].value
            AttributeType.STRENGTH -> strength = AttributeStore.STRENGTH[position].value
            AttributeType.ENDURANCE -> endurance = AttributeStore.ENDURANCE[position].value
        }
        updateCreature()
    }

    fun drawableSelected(drawable: Int) {
        this.drawable = drawable
        updateCreature()
    }

    fun saveCreature(): Boolean {
        return if (canSaveCreature()) {
            repository.saveCreature(creature)
            true
        } else {
            false
        }
    }

    fun canSaveCreature() =
        intelligence != 0 && strength != 0 && endurance != 0 && name.isNotEmpty() && drawable != 0
}