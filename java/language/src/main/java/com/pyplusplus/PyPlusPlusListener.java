// Generated from PyPlusPlus.g4 by ANTLR 4.13.2
package com.pyplusplus;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PyPlusPlusParser}.
 */
public interface PyPlusPlusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PyPlusPlusParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PyPlusPlusParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(PyPlusPlusParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(PyPlusPlusParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PyPlusPlusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PyPlusPlusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(PyPlusPlusParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(PyPlusPlusParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile_loop(PyPlusPlusParser.While_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile_loop(PyPlusPlusParser.While_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterFor_loop(PyPlusPlusParser.For_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitFor_loop(PyPlusPlusParser.For_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(PyPlusPlusParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(PyPlusPlusParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(PyPlusPlusParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(PyPlusPlusParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#variable_instantiation}.
	 * @param ctx the parse tree
	 */
	void enterVariable_instantiation(PyPlusPlusParser.Variable_instantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#variable_instantiation}.
	 * @param ctx the parse tree
	 */
	void exitVariable_instantiation(PyPlusPlusParser.Variable_instantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#list_declaration}.
	 * @param ctx the parse tree
	 */
	void enterList_declaration(PyPlusPlusParser.List_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#list_declaration}.
	 * @param ctx the parse tree
	 */
	void exitList_declaration(PyPlusPlusParser.List_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#list_access}.
	 * @param ctx the parse tree
	 */
	void enterList_access(PyPlusPlusParser.List_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#list_access}.
	 * @param ctx the parse tree
	 */
	void exitList_access(PyPlusPlusParser.List_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#value_assignment}.
	 * @param ctx the parse tree
	 */
	void enterValue_assignment(PyPlusPlusParser.Value_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#value_assignment}.
	 * @param ctx the parse tree
	 */
	void exitValue_assignment(PyPlusPlusParser.Value_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PyPlusPlusParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PyPlusPlusParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(PyPlusPlusParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(PyPlusPlusParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void enterXorExpr(PyPlusPlusParser.XorExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void exitXorExpr(PyPlusPlusParser.XorExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(PyPlusPlusParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(PyPlusPlusParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#comparisonExpr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(PyPlusPlusParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#comparisonExpr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(PyPlusPlusParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(PyPlusPlusParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(PyPlusPlusParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(PyPlusPlusParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(PyPlusPlusParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#powExpr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(PyPlusPlusParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#powExpr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(PyPlusPlusParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(PyPlusPlusParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(PyPlusPlusParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(PyPlusPlusParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(PyPlusPlusParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PyPlusPlusParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PyPlusPlusParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PyPlusPlusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PyPlusPlusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyPlusPlusParser#literal_list}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_list(PyPlusPlusParser.Literal_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyPlusPlusParser#literal_list}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_list(PyPlusPlusParser.Literal_listContext ctx);
}