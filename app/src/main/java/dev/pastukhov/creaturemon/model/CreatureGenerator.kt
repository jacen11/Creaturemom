package dev.pastukhov.creaturemon.model

class CreatureGenerator {
    fun generateCreature(attributes: CreatureAttributes, name: String = "", drawable: Int = 0): Creature {
        val hitPoint = 5 * attributes.intelligence + 3 * attributes.strength + 4 * attributes.endurance
        return Creature(attributes = attributes, hitPoints = hitPoint, name = name, drawable = drawable)
    }
}