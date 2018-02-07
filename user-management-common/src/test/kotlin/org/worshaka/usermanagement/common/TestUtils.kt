package org.worshaka.usermanagement.common

import com.natpryce.hamkrest.MatchResult
import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.should.shouldMatch
import org.assertj.core.api.Assertions.assertThat

infix fun <T>T.shouldMatchFields(expected: T) = this shouldMatch equalFieldsTo(expected)

fun <T> equalFieldsTo(expected: T) = object : Matcher<T> {
    override val description: String
        get() = ""

    override fun invoke(actual: T): MatchResult = try {
        assertThat(this).isEqualToComparingFieldByFieldRecursively(expected)
        MatchResult.Match
    } catch (ex: Exception) {
        MatchResult.Mismatch(ex.message ?: "")
    }
}
