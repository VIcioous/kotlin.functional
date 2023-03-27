package com.kotlin.functional

import javax.persistence.*

typealias Children = Set<Person>

@Entity
data class Person(
    val name: String,
    val currentAccountStatus: Double,
    val moneySpent: Double,
    val monthlyIncome: Double,
    val incomingPayments: Double,
    @OneToMany(cascade = [CascadeType.ALL])
    val children: Children,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
) {
    val allSubunits: Children
        get() = children + children.flatMap { it.allSubunits }
}