package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessAuto
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.preferences.ReaderFontFamily
import com.example.data.preferences.ReaderFontSize
import com.example.data.preferences.ReaderSettings
import com.example.data.preferences.ReaderThemeMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingSettingsBottomSheet(
    settings: ReaderSettings,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onThemeChange: (ReaderThemeMode) -> Unit,
    onFontSizeChange: (ReaderFontSize) -> Unit,
    onFontFamilyChange: (ReaderFontFamily) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = Modifier.testTag("reading_settings_sheet")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 36.dp)
        ) {
            Text(
                text = "Ajustes de Leitura",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Tema visual
            Text(
                text = "Tema da Leitura",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ThemeOptionItem(
                    label = "Claro",
                    bgColor = Color(0xFFFAF9FC),
                    textColor = Color(0xFF1E1E24),
                    icon = Icons.Default.LightMode,
                    isSelected = settings.themeMode == ReaderThemeMode.LIGHT,
                    onClick = { onThemeChange(ReaderThemeMode.LIGHT) },
                    modifier = Modifier.weight(1f)
                )

                ThemeOptionItem(
                    label = "Sépia",
                    bgColor = Color(0xFFF6F0DF),
                    textColor = Color(0xFF382E20),
                    icon = Icons.Default.WbSunny,
                    isSelected = settings.themeMode == ReaderThemeMode.SEPIA,
                    onClick = { onThemeChange(ReaderThemeMode.SEPIA) },
                    modifier = Modifier.weight(1f)
                )

                ThemeOptionItem(
                    label = "Escuro",
                    bgColor = Color(0xFF16171D),
                    textColor = Color(0xFFE2E3EB),
                    icon = Icons.Default.DarkMode,
                    isSelected = settings.themeMode == ReaderThemeMode.DARK,
                    onClick = { onThemeChange(ReaderThemeMode.DARK) },
                    modifier = Modifier.weight(1f)
                )

                ThemeOptionItem(
                    label = "Auto",
                    bgColor = MaterialTheme.colorScheme.surfaceVariant,
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    icon = Icons.Default.BrightnessAuto,
                    isSelected = settings.themeMode == ReaderThemeMode.SYSTEM,
                    onClick = { onThemeChange(ReaderThemeMode.SYSTEM) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tamanho da fonte
            Text(
                text = "Tamanho do Texto",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ReaderFontSize.entries.forEach { size ->
                    FilterChip(
                        selected = settings.fontSize == size,
                        onClick = { onFontSizeChange(size) },
                        label = { Text(size.label) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.FormatSize,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Família da fonte
            Text(
                text = "Estilo de Fonte",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ReaderFontFamily.entries.forEach { family ->
                    FilterChip(
                        selected = settings.fontFamily == family,
                        onClick = { onFontFamilyChange(family) },
                        label = { Text(family.label) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ThemeOptionItem(
    label: String,
    bgColor: Color,
    textColor: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .border(
                width = if (isSelected) 2.5.dp else 1.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = textColor
            )
        }
    }
}
