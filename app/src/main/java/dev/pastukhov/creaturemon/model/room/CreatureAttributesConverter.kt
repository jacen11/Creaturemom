package dev.pastukhov.creaturemon.model.room

import androidx.room.TypeConverter
import dev.pastukhov.creaturemon.model.CreatureAttributes
import java.util.*

class CreatureAttributesConverter {
    @TypeConverter
    fun fromCreatureAttributes(attributes: CreatureAttributes?): String? {
        return if (attributes != null) String.format(
            Locale.US,
            "%d,%d,%d",
            attributes.intelligence,
            attributes.strength,
            attributes.endurance
        ) else null
    }

    @TypeConverter
    fun toCreatureAttributes(value: String?): CreatureAttributes? {
        return if (value != null) {
            val pieces = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            CreatureAttributes(
                Integer.parseInt(pieces[0]),
                Integer.parseInt(pieces[1]),
                Integer.parseInt(pieces[2])
            )
        } else null
    }
}