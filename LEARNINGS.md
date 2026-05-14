# Learnings

## What I Built
A console-based Enhanced Calculator using Java OOP principles,
BigDecimal precision, and exception handling.

## What I Learned
1. Why BigDecimal is used instead of double for precise calculations
2. How OOP Inheritance works - ScientificCalculator extends BasicCalculator
3. How to handle exceptions using try-catch blocks
4. How to structure a Java project using packages

## Hardest Bug I Faced
After moving files to packages, I got errors:
"package com.calculator.scientific does not exist"

## How I Fixed It
I opened each Java file and added the correct
package declaration at the top of each file.
For example: package com.calculator.scientific;

## Key Takeaway
Always use BigDecimal for money calculations.
0.1 + 0.2 in double gives 0.30000000004
0.1 + 0.2 in BigDecimal gives exactly 0.3