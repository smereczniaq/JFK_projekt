// Generated from PyPlusPlus.g4 by ANTLR 4.13.2
package com.pyplusplus;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PyPlusPlusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PyPlusPlusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(PyPlusPlusParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PyPlusPlusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#struct_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_definition(PyPlusPlusParser.Struct_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#struct_member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_member(PyPlusPlusParser.Struct_memberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#class_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_definition(PyPlusPlusParser.Class_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#class_member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_member(PyPlusPlusParser.Class_memberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(PyPlusPlusParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PyPlusPlusParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(PyPlusPlusParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(PyPlusPlusParser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(PyPlusPlusParser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(PyPlusPlusParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(PyPlusPlusParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#variable_instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_instantiation(PyPlusPlusParser.Variable_instantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#list_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_declaration(PyPlusPlusParser.List_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#list_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_access(PyPlusPlusParser.List_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#value_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_assignment(PyPlusPlusParser.Value_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PyPlusPlusParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpr(PyPlusPlusParser.LogicalOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#xorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpr(PyPlusPlusParser.XorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpr(PyPlusPlusParser.LogicalAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#comparisonExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(PyPlusPlusParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(PyPlusPlusParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(PyPlusPlusParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#powExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(PyPlusPlusParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(PyPlusPlusParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(PyPlusPlusParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PyPlusPlusParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyPlusPlusParser#literal_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_list(PyPlusPlusParser.Literal_listContext ctx);
}