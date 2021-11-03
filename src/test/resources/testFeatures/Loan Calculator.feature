#Author: MainRababa@gmail.com
#Keywords Assesemnet for ANB :
@SmokeTest

Feature: Verify that Field is required error is appear
  
   Scenario: Verfiy borrowing amount
   Given User on How much can I borrow page
   And Chose the application type as single
   And Chose 0 as number of dependents
   And Chose Property type as Home to live in
   And fill your income before tax field with 80000
   And fill Other income field with 10000
   And fill Living Expenses field with 500
   And fill Current Home Loan Repayments field with 0
   And fill Other Loans repayments field with 100
   And fill other commitments field with 0
   And fill Total credit card limits field with 10,000
    When user click on work out how much i could borrow
    Then borrowing estimate should be $508,000
    
Scenario: Check call Us message 
  Given User on How much can I borrow page
   And Chose the application type as single
   And Chose 0 as number of dependents
   And Chose Property type as Home to live in
   And fill Living Expenses field with 1
   When user click on work out how much i could borrow
   Then call us message shouold appear
   
   Scenario: Verify validation message
   Given User on How much can I borrow page
   And Chose the application type as single
   And Chose 0 as number of dependents
   And fill your income before tax field with 80000
   And fill Other income field with 10000
   And Chose Property type as Home to live in
   When user click on work out how much i could borrow
   Then Required field should be displayed
   
   