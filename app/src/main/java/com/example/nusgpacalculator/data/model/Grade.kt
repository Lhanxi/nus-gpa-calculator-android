package com.example.nusgpacalculator.data.model

enum class Grade(val gradePoint: Double?) {
    A_PLUS(5.0),
    A(5.0),
    A_MINUS(4.5),
    B_PLUS(4.0),
    B(3.5),
    B_MINUS(3.0),
    C_PLUS(2.5),
    C(2.0),
    D_PLUS(1.5),
    D(1.0),
    F(0.0),

    SATISFACTORY(null),
    UNSATISFACTORY(null),
    COMPLETED_SATISFACTORY(null),
    COMPLETED_UNSATISFACTORY(null),
    INCOMPLETE(null),
    IN_PROGRESS(null),
    WITHDRAWN(null),
    AUDIT(null),
    EXEMPTED(null),
    WITHDRAWAL_UNIVERSITY(null);

    val contributesToGPA: Boolean
        get() = gradePoint != null
}