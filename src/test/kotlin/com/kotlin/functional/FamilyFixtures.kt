package com.kotlin.functional

object FamilyFixtures {

    fun multigenerationalFamily(): Person {
        val paris = person()
        val berlin = person().withName("Berlin")
        val madrid = person().withName("Madrid")
            .withCurrentAmountStatus(500.0)
        val london = person().withName("London")
            .withMoneySpent(300.0)
        val lisbon = person().withName("Lisbon")
            .withMonthlyIncome(600.0)
            .withChildren(paris, berlin)
        val roma = person().withName("Roma")
            .withIncomingPayments(200.0)
            .withChildren(madrid, london)
        return person().withName("Warsaw")
            .withChildren(lisbon, roma)

    }

    private fun person() =
        Person(
            name = "Paris",
            currentAccountStatus = 1000.0,
            moneySpent = 50.0,
            monthlyIncome = 200.0,
            incomingPayments = 300.0,
            children = emptySet(),
            id = null
        )

    private fun Person.withName(name: String) = this.copy(name = name)
    private fun Person.withCurrentAmountStatus(amount: Double) =
        this.copy(currentAccountStatus = amount)

    fun Person.withMoneySpent(amount: Double) = this.copy(moneySpent = amount)
    fun Person.withMonthlyIncome(amount: Double) = this.copy(monthlyIncome = amount)
    fun Person.withIncomingPayments(amount: Double) = this.copy(incomingPayments = amount)
    fun Person.withChildren(vararg children: Person) = this.copy(children = children.toSet())
}