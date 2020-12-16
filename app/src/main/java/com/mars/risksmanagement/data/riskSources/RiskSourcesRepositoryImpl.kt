package com.mars.risksmanagement.data.riskSources

import com.mars.risksmanagement.data.riskSources.models.RiskSource
import com.mars.risksmanagement.data.riskSources.models.SourceGroup

class RiskSourcesRepositoryImpl : RiskSourcesRepository {

    private val sourceGroups: List<RiskSourcesRepository.ISourceGroup> = listOf(
        SourceGroup(1, "Технічні ризики"),
        SourceGroup(2, "Фінансові ризики"),
        SourceGroup(3, "Ризики управління"),
        SourceGroup(4, "Планові ризики"),
    )

    private val sources: List<RiskSourcesRepository.IRiskSource> = listOf(
        RiskSource(1, "Функціональні характеристики ПЗ", sourceGroups[0]),
        RiskSource(2, "Характеристики якості ПЗ", sourceGroups[0]),
        RiskSource(3, "Характеристики надійності ПЗ", sourceGroups[0]),
        RiskSource(4, "Застосовуваність ПЗ", sourceGroups[0]),
        RiskSource(5, "Часова продуктивність ПЗ", sourceGroups[0]),
        RiskSource(6, "Супроводжуваність ПЗ", sourceGroups[0]),
        RiskSource(7, "Повторне використання компонент ПЗ", sourceGroups[0]),

        RiskSource(8, "Обмеження сумарного бюджету на програмний проект", sourceGroups[1]),
        RiskSource(9, "Недоступна вартість реалізації програмного проекту", sourceGroups[1]),
        RiskSource(10, "Низька ступінь реалізму при оцінбванні витрат на проект", sourceGroups[1]),

        RiskSource(11, "Властивості та можливості гнучкості внесення змін до планів життєвого циклу розроблення ПЗ", sourceGroups[2]),
        RiskSource(12, "Можливості порушення встановлених термінів реалізації етапів життєвого циклу розроблення ПЗ", sourceGroups[2]),
        RiskSource(13, "Низька ступінь реалізму при встановленні планів і етапів життєвого циклу розроблення ПЗ", sourceGroups[2]),

        RiskSource(14, "Хибна стратегія реалізації програмного проекту", sourceGroups[3]),
        RiskSource(15, "Неефективне планування проекту розроблення ПЗ", sourceGroups[3]),
        RiskSource(16, "Неякісне оцінювання програмного продукту", sourceGroups[3]),
        RiskSource(17, "Прогалини в документуванні етапів реалізації ПП", sourceGroups[3]),
        RiskSource(18, "Промахи в прогнозуванні результатів реалізації програмного проекту", sourceGroups[3]),
    )

    override fun getSources(): List<RiskSourcesRepository.IRiskSource> {
        return sources
    }

    override fun getGroups(): List<RiskSourcesRepository.ISourceGroup> {
        return sourceGroups
    }
}