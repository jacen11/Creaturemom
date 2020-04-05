package ru.dpastukhov.creaturemom.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import ru.dpastukhov.creaturemom.model.Creature
import ru.dpastukhov.creaturemom.model.CreatureAttributes
import ru.dpastukhov.creaturemom.model.CreatureGenerator

class CreatureViewModelTest {
    private lateinit var creatureViewModel: CreatureViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockGenerator: CreatureGenerator

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        creatureViewModel = CreatureViewModel(mockGenerator)
    }

    @Test
    fun testSetupCreature() {
        val attributes = CreatureAttributes(10, 3, 7)
        val stubCreature = Creature(attributes, 87, "Test Creature")
        `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)

        creatureViewModel.apply {
            intelligence = 10
            strength = 3
            endurance = 7
            updateCreature()
        }

        assertEquals(stubCreature, creatureViewModel.creature)
    }

}