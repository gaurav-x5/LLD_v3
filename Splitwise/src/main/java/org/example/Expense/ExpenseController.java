package org.example.Expense;

import org.example.BalanceSheetController;
import org.example.Expense.Split.ExpenseSplit;
import org.example.Expense.Split.Split;
import org.example.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splits, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splits, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splits);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splits, expenseAmount);
        return expense;
    }
}
