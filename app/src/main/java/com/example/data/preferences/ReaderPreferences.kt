package com.example.data.preferences

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class ReaderThemeMode {
    SYSTEM,
    LIGHT,
    SEPIA,
    DARK
}

enum class ReaderFontSize(val scaleFactor: Float, val label: String) {
    SMALL(0.85f, "Pequeno"),
    MEDIUM(1.0f, "Médio"),
    LARGE(1.2f, "Grande"),
    EXTRA_LARGE(1.4f, "Extra")
}

enum class ReaderFontFamily(val label: String) {
    SANS_SERIF("Sem Serifa (Moderna)"),
    SERIF("Com Serifa (Livro)")
}

data class ReaderSettings(
    val themeMode: ReaderThemeMode = ReaderThemeMode.SYSTEM,
    val fontSize: ReaderFontSize = ReaderFontSize.MEDIUM,
    val fontFamily: ReaderFontFamily = ReaderFontFamily.SANS_SERIF
)

class ReaderPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("reader_settings_prefs", Context.MODE_PRIVATE)

    private val _settings = MutableStateFlow(loadSettings())
    val settings: StateFlow<ReaderSettings> = _settings.asStateFlow()

    private fun loadSettings(): ReaderSettings {
        val themeOrdinal = prefs.getInt(KEY_THEME, ReaderThemeMode.SYSTEM.ordinal)
        val fontOrdinal = prefs.getInt(KEY_FONT_SIZE, ReaderFontSize.MEDIUM.ordinal)
        val familyOrdinal = prefs.getInt(KEY_FONT_FAMILY, ReaderFontFamily.SANS_SERIF.ordinal)

        val theme = ReaderThemeMode.entries.getOrElse(themeOrdinal) { ReaderThemeMode.SYSTEM }
        val fontSize = ReaderFontSize.entries.getOrElse(fontOrdinal) { ReaderFontSize.MEDIUM }
        val fontFamily = ReaderFontFamily.entries.getOrElse(familyOrdinal) { ReaderFontFamily.SANS_SERIF }

        return ReaderSettings(theme, fontSize, fontFamily)
    }

    fun setThemeMode(mode: ReaderThemeMode) {
        prefs.edit().putInt(KEY_THEME, mode.ordinal).apply()
        _settings.value = _settings.value.copy(themeMode = mode)
    }

    fun setFontSize(size: ReaderFontSize) {
        prefs.edit().putInt(KEY_FONT_SIZE, size.ordinal).apply()
        _settings.value = _settings.value.copy(fontSize = size)
    }

    fun setFontFamily(family: ReaderFontFamily) {
        prefs.edit().putInt(KEY_FONT_FAMILY, family.ordinal).apply()
        _settings.value = _settings.value.copy(fontFamily = family)
    }

    companion object {
        private const val KEY_THEME = "reader_theme"
        private const val KEY_FONT_SIZE = "reader_font_size"
        private const val KEY_FONT_FAMILY = "reader_font_family"
    }
}
