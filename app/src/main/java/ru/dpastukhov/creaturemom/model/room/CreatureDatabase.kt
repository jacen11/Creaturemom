package ru.dpastukhov.creaturemom.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.dpastukhov.creaturemom.model.Creature

@Database(entities = [(Creature::class)], version = 1)
@TypeConverters(CreatureAttributesConverter::class)
abstract class CreatureDatabase : RoomDatabase() {
    abstract fun creatureDao(): CreatureDao
}