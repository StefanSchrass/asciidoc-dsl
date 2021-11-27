package io.github.sschrass.asciidoc.dsl

class SectionNumbers(
    private var enabled: Boolean
) : Element {

    override fun render(builder: StringBuilder) {
        takeIf { enabled }
            ?.also { builder.append(":sectnums:") }
            ?: builder.append(":sectnums!:")
        builder.append(System.lineSeparator())
    }
}
