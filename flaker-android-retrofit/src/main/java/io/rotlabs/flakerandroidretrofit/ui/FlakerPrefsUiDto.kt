package io.rotlabs.flakerandroidretrofit.ui

data class FlakerPrefsUiDto(
    val delay: Int,
    val failPercent: Int,
    val variancePercent: Int,
) {
    companion object {
        val IMMATERIAL = FlakerPrefsUiDto(
            delay = -1,
            failPercent = -1,
            variancePercent = -1
        )
    }
}