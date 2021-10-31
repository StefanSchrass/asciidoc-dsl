package io.github.sschrass.asciidoc.dsl

class Section(
    private val level: Int
) : Element {
    private var title: Title? = null
    private val elements = mutableListOf<Element>()

    fun title(init: Title.() -> Unit) = Title(level)
        .also(init)
        .also { title = it }

    fun paragraph(init: Paragraph.() -> Unit) = Paragraph()
        .also(init)
        .also(elements::add)

    fun subSection(init: Section.() -> Unit) = Section(level + 1)
        .also(init)
        .also(elements::add)

    fun list(init: List.() -> Unit) = List()
        .also(init)
        .also(elements::add)

    override fun render(builder: StringBuilder) {
        title?.also { it.render(builder) }
        elements.forEach { it.render(builder) }
    }
}
