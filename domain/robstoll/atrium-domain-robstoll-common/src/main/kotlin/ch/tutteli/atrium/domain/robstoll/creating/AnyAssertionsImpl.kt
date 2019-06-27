package ch.tutteli.atrium.domain.robstoll.creating

import ch.tutteli.atrium.assertions.Assertion
import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.creating.AssertionPlantNullable
import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.creating.SubjectProvider
import ch.tutteli.atrium.domain.creating.AnyAssertions
import ch.tutteli.atrium.domain.robstoll.lib.creating.*
import kotlin.reflect.KClass

/**
 * Robstoll's implementation of [AnyAssertions].
 */
class AnyAssertionsImpl : AnyAssertions {

    override fun <T : Any> toBe(subjectProvider: SubjectProvider<T>, expected: T) = _toBe(subjectProvider, expected)
    override fun <T : Any?> toBeNull(plant: SubjectProvider<T>) = _toBeNull(plant)

    override fun <T : Any> notToBeNull(
        assertionContainer: Expect<T?>,
        type: KClass<T>,
        assertionCreator: Expect<T>.() -> Unit
    ) = _notToBeNull(assertionContainer, type, assertionCreator)

    override fun <T : Any> toBeNullable(
        assertionContainer: Expect<T?>,
        type: KClass<T>,
        expectedOrNull: T?
    ) = _toBeNullable(assertionContainer, type, expectedOrNull)

    override fun <T : Any> toBeNullIfNullGivenElse(
        assertionContainer: Expect<T?>,
        type: KClass<T>,
        assertionCreatorOrNull: (Expect<T>.() -> Unit)?
    ) = _toBeNullIfNullGivenElse(assertionContainer, type, assertionCreatorOrNull)

    override fun <T : Any> notToBe(plant: AssertionPlant<T>, expected: T) = _notToBe(plant, expected)

    override fun <T : Any> isSame(plant: AssertionPlant<T>, expected: T) = _isSame(plant, expected)

    override fun <T : Any> isNotSame(plant: AssertionPlant<T>, expected: T) = _isNotSame(plant, expected)

    override fun <T : Any> isNullable(
        plant: AssertionPlantNullable<T?>,
        type: KClass<T>,
        expectedOrNull: T?
    ) = _isNullable(plant, type, expectedOrNull)

    override fun <T : Any> isNotNull(
        plant: AssertionPlantNullable<T?>,
        type: KClass<T>,
        assertionCreator: AssertionPlant<T>.() -> Unit
    ) = _isNotNull(plant, type, assertionCreator)

    override fun <T : Any> isNotNullBut(
        plant: AssertionPlantNullable<T?>,
        type: KClass<T>,
        expected: T
    ) = _isNotNullBut(plant, type, expected)

    override fun <T : Any> isNullIfNullGivenElse(
        plant: AssertionPlantNullable<T?>,
        type: KClass<T>,
        assertionCreatorOrNull: (AssertionPlant<T>.() -> Unit)?
    ) = _isNullIfNullGivenElse(plant, type, assertionCreatorOrNull)
}
