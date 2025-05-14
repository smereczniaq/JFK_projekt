// Generated from PyPlusPlus.g4 by ANTLR 4.13.2
package com.pyplusplus;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PyPlusPlusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, ARROW=45, 
		IDENTIFIER=46, INTEGER=47, FLOAT=48, STRING=49, BOOL=50, WS=51, COMMENT=52;
	public static final int
		RULE_prog = 0, RULE_type = 1, RULE_struct_definition = 2, RULE_struct_member = 3, 
		RULE_class_definition = 4, RULE_class_member = 5, RULE_function_definition = 6, 
		RULE_statement = 7, RULE_return_statement = 8, RULE_while_loop = 9, RULE_for_loop = 10, 
		RULE_if_statement = 11, RULE_function_call = 12, RULE_variable_instantiation = 13, 
		RULE_list_declaration = 14, RULE_list_access = 15, RULE_value_assignment = 16, 
		RULE_expression = 17, RULE_logicalOrExpr = 18, RULE_xorExpr = 19, RULE_logicalAndExpr = 20, 
		RULE_comparisonExpr = 21, RULE_addExpr = 22, RULE_mulExpr = 23, RULE_powExpr = 24, 
		RULE_unaryExpr = 25, RULE_primary = 26, RULE_literal = 27, RULE_literal_list = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "type", "struct_definition", "struct_member", "class_definition", 
			"class_member", "function_definition", "statement", "return_statement", 
			"while_loop", "for_loop", "if_statement", "function_call", "variable_instantiation", 
			"list_declaration", "list_access", "value_assignment", "expression", 
			"logicalOrExpr", "xorExpr", "logicalAndExpr", "comparisonExpr", "addExpr", 
			"mulExpr", "powExpr", "unaryExpr", "primary", "literal", "literal_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'double'", "'float'", "'Float32'", "'Float64'", "'string'", 
			"'bool'", "'list'", "'struct'", "'{'", "'}'", "';'", "'='", "'class'", 
			"'fun'", "'('", "','", "')'", "'break'", "'continue'", "'return'", "'while'", 
			"'for'", "'in'", "'if'", "'else'", "'var'", "'['", "']'", "'||'", "'#'", 
			"'&&'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", 
			"'/'", "'^'", "'!'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "ARROW", "IDENTIFIER", 
			"INTEGER", "FLOAT", "STRING", "BOOL", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PyPlusPlus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PyPlusPlusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PyPlusPlusParser.EOF, 0); }
		public List<Struct_definitionContext> struct_definition() {
			return getRuleContexts(Struct_definitionContext.class);
		}
		public Struct_definitionContext struct_definition(int i) {
			return getRuleContext(Struct_definitionContext.class,i);
		}
		public List<Class_definitionContext> class_definition() {
			return getRuleContexts(Class_definitionContext.class);
		}
		public Class_definitionContext class_definition(int i) {
			return getRuleContext(Class_definitionContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219755776L) != 0)) {
				{
				setState(62);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(58);
					struct_definition();
					}
					break;
				case T__13:
					{
					setState(59);
					class_definition();
					}
					break;
				case T__14:
					{
					setState(60);
					function_definition();
					}
					break;
				case T__7:
				case T__15:
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__24:
				case T__26:
				case T__27:
				case T__39:
				case T__43:
				case IDENTIFIER:
				case INTEGER:
				case FLOAT:
				case STRING:
				case BOOL:
					{
					setState(61);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 70368744178174L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_definitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public List<Struct_memberContext> struct_member() {
			return getRuleContexts(Struct_memberContext.class);
		}
		public Struct_memberContext struct_member(int i) {
			return getRuleContext(Struct_memberContext.class,i);
		}
		public Struct_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterStruct_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitStruct_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitStruct_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_definitionContext struct_definition() throws RecognitionException {
		Struct_definitionContext _localctx = new Struct_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_struct_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__8);
			setState(72);
			match(IDENTIFIER);
			setState(73);
			match(T__9);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70368744178174L) != 0)) {
				{
				{
				setState(74);
				struct_member();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(T__10);
			setState(81);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_memberContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Struct_memberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterStruct_member(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitStruct_member(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitStruct_member(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_memberContext struct_member() throws RecognitionException {
		Struct_memberContext _localctx = new Struct_memberContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_struct_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			type();
			setState(84);
			match(IDENTIFIER);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(85);
				match(T__12);
				setState(86);
				expression();
				}
			}

			setState(89);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_definitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public List<Class_memberContext> class_member() {
			return getRuleContexts(Class_memberContext.class);
		}
		public Class_memberContext class_member(int i) {
			return getRuleContext(Class_memberContext.class,i);
		}
		public Class_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterClass_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitClass_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitClass_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_definitionContext class_definition() throws RecognitionException {
		Class_definitionContext _localctx = new Class_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__13);
			setState(92);
			match(IDENTIFIER);
			setState(93);
			match(T__9);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__26) {
				{
				{
				setState(94);
				class_member();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(T__10);
			setState(101);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_memberContext extends ParserRuleContext {
		public Variable_instantiationContext variable_instantiation() {
			return getRuleContext(Variable_instantiationContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public Class_memberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterClass_member(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitClass_member(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitClass_member(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_memberContext class_member() throws RecognitionException {
		Class_memberContext _localctx = new Class_memberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_class_member);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				variable_instantiation();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				function_definition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PyPlusPlusParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PyPlusPlusParser.IDENTIFIER, i);
		}
		public TerminalNode ARROW() { return getToken(PyPlusPlusParser.ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitFunction_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__14);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(108);
				match(ARROW);
				setState(109);
				type();
				}
			}

			setState(112);
			match(IDENTIFIER);
			setState(113);
			match(T__15);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(114);
				match(IDENTIFIER);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(115);
					match(T__16);
					setState(116);
					match(IDENTIFIER);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(124);
			match(T__17);
			setState(125);
			match(T__9);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219706112L) != 0)) {
				{
				{
				setState(126);
				statement();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Variable_instantiationContext variable_instantiation() {
			return getRuleContext(Variable_instantiationContext.class,0);
		}
		public List_declarationContext list_declaration() {
			return getRuleContext(List_declarationContext.class,0);
		}
		public Value_assignmentContext value_assignment() {
			return getRuleContext(Value_assignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				while_loop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				for_loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				if_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				variable_instantiation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				list_declaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				value_assignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140);
				expression();
				setState(141);
				match(T__11);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(143);
				return_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(144);
				match(T__18);
				setState(145);
				match(T__11);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(146);
				match(T__19);
				setState(147);
				match(T__11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__20);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123035680768L) != 0)) {
				{
				setState(151);
				expression();
				}
			}

			setState(154);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_loopContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterWhile_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitWhile_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__21);
			setState(157);
			expression();
			setState(158);
			match(T__9);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219706112L) != 0)) {
				{
				{
				setState(159);
				statement();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_loopContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PyPlusPlusParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PyPlusPlusParser.IDENTIFIER, i);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PyPlusPlusParser.STRING, 0); }
		public Literal_listContext literal_list() {
			return getRuleContext(Literal_listContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterFor_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitFor_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitFor_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__22);
			setState(168);
			match(IDENTIFIER);
			setState(169);
			match(T__23);
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(170);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(171);
				function_call();
				}
				break;
			case 3:
				{
				setState(172);
				match(STRING);
				}
				break;
			case 4:
				{
				setState(173);
				literal_list();
				}
				break;
			}
			setState(176);
			match(T__9);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219706112L) != 0)) {
				{
				{
				setState(177);
				statement();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__24);
			setState(186);
			expression();
			setState(187);
			match(T__9);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219706112L) != 0)) {
				{
				{
				setState(188);
				statement();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(T__10);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(195);
					match(T__25);
					setState(196);
					match(T__24);
					setState(197);
					expression();
					setState(198);
					match(T__9);
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219706112L) != 0)) {
						{
						{
						setState(199);
						statement();
						}
						}
						setState(204);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(205);
					match(T__10);
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(212);
				match(T__25);
				setState(213);
				match(T__9);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123219706112L) != 0)) {
					{
					{
					setState(214);
					statement();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(T__10);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(IDENTIFIER);
			setState(224);
			match(T__15);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2200123035680768L) != 0)) {
				{
				setState(225);
				expression();
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(226);
					match(T__16);
					setState(227);
					expression();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(235);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_instantiationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Variable_instantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_instantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterVariable_instantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitVariable_instantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitVariable_instantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_instantiationContext variable_instantiation() throws RecognitionException {
		Variable_instantiationContext _localctx = new Variable_instantiationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable_instantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__26);
			setState(238);
			match(IDENTIFIER);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(239);
				match(T__12);
				setState(240);
				expression();
				}
			}

			setState(243);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_declarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public Literal_listContext literal_list() {
			return getRuleContext(Literal_listContext.class,0);
		}
		public List_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterList_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitList_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitList_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_declarationContext list_declaration() throws RecognitionException {
		List_declarationContext _localctx = new List_declarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_list_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(T__7);
			setState(246);
			match(IDENTIFIER);
			setState(247);
			match(T__12);
			setState(248);
			literal_list();
			setState(249);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_accessContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterList_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitList_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitList_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_accessContext list_access() throws RecognitionException {
		List_accessContext _localctx = new List_accessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_list_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(IDENTIFIER);
			setState(252);
			match(T__27);
			setState(253);
			expression();
			setState(254);
			match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_assignmentContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Value_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterValue_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitValue_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitValue_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_assignmentContext value_assignment() throws RecognitionException {
		Value_assignmentContext _localctx = new Value_assignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			expression();
			setState(257);
			match(T__12);
			setState(258);
			expression();
			setState(259);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			logicalOrExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExprContext extends ParserRuleContext {
		public List<XorExprContext> xorExpr() {
			return getRuleContexts(XorExprContext.class);
		}
		public XorExprContext xorExpr(int i) {
			return getRuleContext(XorExprContext.class,i);
		}
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLogicalOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLogicalOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitLogicalOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			xorExpr();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(264);
				match(T__29);
				setState(265);
				xorExpr();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XorExprContext extends ParserRuleContext {
		public List<LogicalAndExprContext> logicalAndExpr() {
			return getRuleContexts(LogicalAndExprContext.class);
		}
		public LogicalAndExprContext logicalAndExpr(int i) {
			return getRuleContext(LogicalAndExprContext.class,i);
		}
		public XorExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xorExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterXorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitXorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitXorExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorExprContext xorExpr() throws RecognitionException {
		XorExprContext _localctx = new XorExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_xorExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			logicalAndExpr();
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(272);
				match(T__30);
				setState(273);
				logicalAndExpr();
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExprContext extends ParserRuleContext {
		public List<ComparisonExprContext> comparisonExpr() {
			return getRuleContexts(ComparisonExprContext.class);
		}
		public ComparisonExprContext comparisonExpr(int i) {
			return getRuleContext(ComparisonExprContext.class,i);
		}
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLogicalAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLogicalAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitLogicalAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			comparisonExpr();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31) {
				{
				{
				setState(280);
				match(T__31);
				setState(281);
				comparisonExpr();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ParserRuleContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public ComparisonExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterComparisonExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitComparisonExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitComparisonExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExprContext comparisonExpr() throws RecognitionException {
		ComparisonExprContext _localctx = new ComparisonExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comparisonExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			addExpr();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 541165879296L) != 0)) {
				{
				{
				setState(288);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 541165879296L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(289);
				addExpr();
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ParserRuleContext {
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			mulExpr();
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38 || _la==T__39) {
				{
				{
				setState(296);
				_la = _input.LA(1);
				if ( !(_la==T__38 || _la==T__39) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(297);
				mulExpr();
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ParserRuleContext {
		public List<PowExprContext> powExpr() {
			return getRuleContexts(PowExprContext.class);
		}
		public PowExprContext powExpr(int i) {
			return getRuleContext(PowExprContext.class,i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			powExpr();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40 || _la==T__41) {
				{
				{
				setState(304);
				_la = _input.LA(1);
				if ( !(_la==T__40 || _la==T__41) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(305);
				powExpr();
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PowExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PowExprContext powExpr() {
			return getRuleContext(PowExprContext.class,0);
		}
		public PowExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowExprContext powExpr() throws RecognitionException {
		PowExprContext _localctx = new PowExprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_powExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			unaryExpr();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(312);
				match(T__42);
				setState(313);
				powExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryExpr);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				match(T__39);
				setState(317);
				unaryExpr();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				match(T__43);
				setState(319);
				unaryExpr();
				}
				break;
			case T__15:
			case T__27:
			case IDENTIFIER:
			case INTEGER:
			case FLOAT:
			case STRING:
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List_accessContext list_access() {
			return getRuleContext(List_accessContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary);
		try {
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				match(T__15);
				setState(324);
				expression();
				setState(325);
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				list_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(328);
				function_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(PyPlusPlusParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(PyPlusPlusParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(PyPlusPlusParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(PyPlusPlusParser.BOOL, 0); }
		public Literal_listContext literal_list() {
			return getRuleContext(Literal_listContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_literal);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				match(FLOAT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(335);
				match(STRING);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(336);
				match(BOOL);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(337);
				literal_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Literal_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Literal_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLiteral_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLiteral_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyPlusPlusVisitor ) return ((PyPlusPlusVisitor<? extends T>)visitor).visitLiteral_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_listContext literal_list() throws RecognitionException {
		Literal_listContext _localctx = new Literal_listContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_literal_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__27);
			setState(341);
			expression();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(342);
				match(T__16);
				setState(343);
				expression();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
			match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u0160\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000?\b\u0000\n\u0000\f\u0000B\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002L\b\u0002\n\u0002\f\u0002O\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"X\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004`\b\u0004\n\u0004\f\u0004c\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005j\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006o\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006v\b\u0006"+
		"\n\u0006\f\u0006y\t\u0006\u0003\u0006{\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0080\b\u0006\n\u0006\f\u0006\u0083\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0095\b\u0007\u0001"+
		"\b\u0001\b\u0003\b\u0099\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00a1\b\t\n\t\f\t\u00a4\t\t\u0001\t\u0001\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00af\b\n\u0001\n\u0001"+
		"\n\u0005\n\u00b3\b\n\n\n\f\n\u00b6\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00be\b\u000b\n\u000b\f\u000b"+
		"\u00c1\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00c9\b\u000b\n\u000b\f\u000b\u00cc\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00d0\b\u000b\n\u000b\f\u000b\u00d3\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d8\b\u000b\n\u000b"+
		"\f\u000b\u00db\t\u000b\u0001\u000b\u0003\u000b\u00de\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u00e5\b\f\n\f\f\f\u00e8\t\f\u0003\f"+
		"\u00ea\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00f2"+
		"\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u010b"+
		"\b\u0012\n\u0012\f\u0012\u010e\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u0113\b\u0013\n\u0013\f\u0013\u0116\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u011b\b\u0014\n\u0014\f\u0014\u011e\t\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0123\b\u0015\n\u0015"+
		"\f\u0015\u0126\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u012b\b\u0016\n\u0016\f\u0016\u012e\t\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0133\b\u0017\n\u0017\f\u0017\u0136\t\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u013b\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0142\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u014c\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u0153\b\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0005\u001c\u0159\b\u001c\n\u001c\f\u001c\u015c"+
		"\t\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468\u0000\u0004\u0002\u0000\u0001\b..\u0001\u0000!&\u0001\u0000"+
		"\'(\u0001\u0000)*\u0177\u0000@\u0001\u0000\u0000\u0000\u0002E\u0001\u0000"+
		"\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006S\u0001\u0000\u0000\u0000"+
		"\b[\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000\u0000\fk\u0001\u0000"+
		"\u0000\u0000\u000e\u0094\u0001\u0000\u0000\u0000\u0010\u0096\u0001\u0000"+
		"\u0000\u0000\u0012\u009c\u0001\u0000\u0000\u0000\u0014\u00a7\u0001\u0000"+
		"\u0000\u0000\u0016\u00b9\u0001\u0000\u0000\u0000\u0018\u00df\u0001\u0000"+
		"\u0000\u0000\u001a\u00ed\u0001\u0000\u0000\u0000\u001c\u00f5\u0001\u0000"+
		"\u0000\u0000\u001e\u00fb\u0001\u0000\u0000\u0000 \u0100\u0001\u0000\u0000"+
		"\u0000\"\u0105\u0001\u0000\u0000\u0000$\u0107\u0001\u0000\u0000\u0000"+
		"&\u010f\u0001\u0000\u0000\u0000(\u0117\u0001\u0000\u0000\u0000*\u011f"+
		"\u0001\u0000\u0000\u0000,\u0127\u0001\u0000\u0000\u0000.\u012f\u0001\u0000"+
		"\u0000\u00000\u0137\u0001\u0000\u0000\u00002\u0141\u0001\u0000\u0000\u0000"+
		"4\u014b\u0001\u0000\u0000\u00006\u0152\u0001\u0000\u0000\u00008\u0154"+
		"\u0001\u0000\u0000\u0000:?\u0003\u0004\u0002\u0000;?\u0003\b\u0004\u0000"+
		"<?\u0003\f\u0006\u0000=?\u0003\u000e\u0007\u0000>:\u0001\u0000\u0000\u0000"+
		">;\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000"+
		"\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0005"+
		"\u0000\u0000\u0001D\u0001\u0001\u0000\u0000\u0000EF\u0007\u0000\u0000"+
		"\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0005\t\u0000\u0000HI\u0005.\u0000"+
		"\u0000IM\u0005\n\u0000\u0000JL\u0003\u0006\u0003\u0000KJ\u0001\u0000\u0000"+
		"\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u000b\u0000\u0000QR\u0005\f\u0000\u0000R\u0005\u0001\u0000\u0000\u0000"+
		"ST\u0003\u0002\u0001\u0000TW\u0005.\u0000\u0000UV\u0005\r\u0000\u0000"+
		"VX\u0003\"\u0011\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000YZ\u0005\f\u0000\u0000Z\u0007\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u000e\u0000\u0000\\]\u0005.\u0000\u0000]a\u0005\n\u0000"+
		"\u0000^`\u0003\n\u0005\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005\u000b\u0000\u0000ef\u0005"+
		"\f\u0000\u0000f\t\u0001\u0000\u0000\u0000gj\u0003\u001a\r\u0000hj\u0003"+
		"\f\u0006\u0000ig\u0001\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000j\u000b"+
		"\u0001\u0000\u0000\u0000kn\u0005\u000f\u0000\u0000lm\u0005-\u0000\u0000"+
		"mo\u0003\u0002\u0001\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pq\u0005.\u0000\u0000qz\u0005\u0010\u0000"+
		"\u0000rw\u0005.\u0000\u0000st\u0005\u0011\u0000\u0000tv\u0005.\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000zr\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|}\u0005\u0012\u0000\u0000}\u0081\u0005\n\u0000\u0000"+
		"~\u0080\u0003\u000e\u0007\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u000b\u0000\u0000\u0085\r\u0001"+
		"\u0000\u0000\u0000\u0086\u0095\u0003\u0012\t\u0000\u0087\u0095\u0003\u0014"+
		"\n\u0000\u0088\u0095\u0003\u0016\u000b\u0000\u0089\u0095\u0003\u001a\r"+
		"\u0000\u008a\u0095\u0003\u001c\u000e\u0000\u008b\u0095\u0003 \u0010\u0000"+
		"\u008c\u008d\u0003\"\u0011\u0000\u008d\u008e\u0005\f\u0000\u0000\u008e"+
		"\u0095\u0001\u0000\u0000\u0000\u008f\u0095\u0003\u0010\b\u0000\u0090\u0091"+
		"\u0005\u0013\u0000\u0000\u0091\u0095\u0005\f\u0000\u0000\u0092\u0093\u0005"+
		"\u0014\u0000\u0000\u0093\u0095\u0005\f\u0000\u0000\u0094\u0086\u0001\u0000"+
		"\u0000\u0000\u0094\u0087\u0001\u0000\u0000\u0000\u0094\u0088\u0001\u0000"+
		"\u0000\u0000\u0094\u0089\u0001\u0000\u0000\u0000\u0094\u008a\u0001\u0000"+
		"\u0000\u0000\u0094\u008b\u0001\u0000\u0000\u0000\u0094\u008c\u0001\u0000"+
		"\u0000\u0000\u0094\u008f\u0001\u0000\u0000\u0000\u0094\u0090\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u000f\u0001\u0000"+
		"\u0000\u0000\u0096\u0098\u0005\u0015\u0000\u0000\u0097\u0099\u0003\"\u0011"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005\f\u0000\u0000"+
		"\u009b\u0011\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0016\u0000\u0000"+
		"\u009d\u009e\u0003\"\u0011\u0000\u009e\u00a2\u0005\n\u0000\u0000\u009f"+
		"\u00a1\u0003\u000e\u0007\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u000b\u0000\u0000\u00a6"+
		"\u0013\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0017\u0000\u0000\u00a8"+
		"\u00a9\u0005.\u0000\u0000\u00a9\u00ae\u0005\u0018\u0000\u0000\u00aa\u00af"+
		"\u0005.\u0000\u0000\u00ab\u00af\u0003\u0018\f\u0000\u00ac\u00af\u0005"+
		"1\u0000\u0000\u00ad\u00af\u00038\u001c\u0000\u00ae\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ae\u00ab\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b4\u0005\n\u0000\u0000\u00b1\u00b3\u0003\u000e\u0007\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0005\u000b\u0000\u0000\u00b8\u0015\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bb\u0003\"\u0011\u0000\u00bb"+
		"\u00bf\u0005\n\u0000\u0000\u00bc\u00be\u0003\u000e\u0007\u0000\u00bd\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00d1"+
		"\u0005\u000b\u0000\u0000\u00c3\u00c4\u0005\u001a\u0000\u0000\u00c4\u00c5"+
		"\u0005\u0019\u0000\u0000\u00c5\u00c6\u0003\"\u0011\u0000\u00c6\u00ca\u0005"+
		"\n\u0000\u0000\u00c7\u00c9\u0003\u000e\u0007\u0000\u00c8\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u000b"+
		"\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00c3\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00dd\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u001a"+
		"\u0000\u0000\u00d5\u00d9\u0005\n\u0000\u0000\u00d6\u00d8\u0003\u000e\u0007"+
		"\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000"+
		"\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000"+
		"\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00dc\u00de\u0005\u000b\u0000\u0000\u00dd\u00d4\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u0017\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005.\u0000\u0000\u00e0\u00e9\u0005\u0010\u0000\u0000"+
		"\u00e1\u00e6\u0003\"\u0011\u0000\u00e2\u00e3\u0005\u0011\u0000\u0000\u00e3"+
		"\u00e5\u0003\"\u0011\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e1\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0005\u0012\u0000\u0000\u00ec\u0019\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0005\u001b\u0000\u0000\u00ee\u00f1\u0005.\u0000\u0000\u00ef\u00f0\u0005"+
		"\r\u0000\u0000\u00f0\u00f2\u0003\"\u0011\u0000\u00f1\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0005\f\u0000\u0000\u00f4\u001b\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0005\b\u0000\u0000\u00f6\u00f7\u0005.\u0000\u0000"+
		"\u00f7\u00f8\u0005\r\u0000\u0000\u00f8\u00f9\u00038\u001c\u0000\u00f9"+
		"\u00fa\u0005\f\u0000\u0000\u00fa\u001d\u0001\u0000\u0000\u0000\u00fb\u00fc"+
		"\u0005.\u0000\u0000\u00fc\u00fd\u0005\u001c\u0000\u0000\u00fd\u00fe\u0003"+
		"\"\u0011\u0000\u00fe\u00ff\u0005\u001d\u0000\u0000\u00ff\u001f\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0003\"\u0011\u0000\u0101\u0102\u0005\r\u0000"+
		"\u0000\u0102\u0103\u0003\"\u0011\u0000\u0103\u0104\u0005\f\u0000\u0000"+
		"\u0104!\u0001\u0000\u0000\u0000\u0105\u0106\u0003$\u0012\u0000\u0106#"+
		"\u0001\u0000\u0000\u0000\u0107\u010c\u0003&\u0013\u0000\u0108\u0109\u0005"+
		"\u001e\u0000\u0000\u0109\u010b\u0003&\u0013\u0000\u010a\u0108\u0001\u0000"+
		"\u0000\u0000\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d%\u0001\u0000\u0000"+
		"\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0114\u0003(\u0014\u0000"+
		"\u0110\u0111\u0005\u001f\u0000\u0000\u0111\u0113\u0003(\u0014\u0000\u0112"+
		"\u0110\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114"+
		"\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115"+
		"\'\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u011c"+
		"\u0003*\u0015\u0000\u0118\u0119\u0005 \u0000\u0000\u0119\u011b\u0003*"+
		"\u0015\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000"+
		"\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000"+
		"\u0000\u0000\u011d)\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000"+
		"\u0000\u011f\u0124\u0003,\u0016\u0000\u0120\u0121\u0007\u0001\u0000\u0000"+
		"\u0121\u0123\u0003,\u0016\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123"+
		"\u0126\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0001\u0000\u0000\u0000\u0125+\u0001\u0000\u0000\u0000\u0126\u0124"+
		"\u0001\u0000\u0000\u0000\u0127\u012c\u0003.\u0017\u0000\u0128\u0129\u0007"+
		"\u0002\u0000\u0000\u0129\u012b\u0003.\u0017\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d-\u0001\u0000\u0000"+
		"\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0134\u00030\u0018\u0000"+
		"\u0130\u0131\u0007\u0003\u0000\u0000\u0131\u0133\u00030\u0018\u0000\u0132"+
		"\u0130\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134"+
		"\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"/\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u013a"+
		"\u00032\u0019\u0000\u0138\u0139\u0005+\u0000\u0000\u0139\u013b\u00030"+
		"\u0018\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000"+
		"\u0000\u0000\u013b1\u0001\u0000\u0000\u0000\u013c\u013d\u0005(\u0000\u0000"+
		"\u013d\u0142\u00032\u0019\u0000\u013e\u013f\u0005,\u0000\u0000\u013f\u0142"+
		"\u00032\u0019\u0000\u0140\u0142\u00034\u001a\u0000\u0141\u013c\u0001\u0000"+
		"\u0000\u0000\u0141\u013e\u0001\u0000\u0000\u0000\u0141\u0140\u0001\u0000"+
		"\u0000\u0000\u01423\u0001\u0000\u0000\u0000\u0143\u0144\u0005\u0010\u0000"+
		"\u0000\u0144\u0145\u0003\"\u0011\u0000\u0145\u0146\u0005\u0012\u0000\u0000"+
		"\u0146\u014c\u0001\u0000\u0000\u0000\u0147\u014c\u0003\u001e\u000f\u0000"+
		"\u0148\u014c\u0003\u0018\f\u0000\u0149\u014c\u00036\u001b\u0000\u014a"+
		"\u014c\u0005.\u0000\u0000\u014b\u0143\u0001\u0000\u0000\u0000\u014b\u0147"+
		"\u0001\u0000\u0000\u0000\u014b\u0148\u0001\u0000\u0000\u0000\u014b\u0149"+
		"\u0001\u0000\u0000\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014c5\u0001"+
		"\u0000\u0000\u0000\u014d\u0153\u0005/\u0000\u0000\u014e\u0153\u00050\u0000"+
		"\u0000\u014f\u0153\u00051\u0000\u0000\u0150\u0153\u00052\u0000\u0000\u0151"+
		"\u0153\u00038\u001c\u0000\u0152\u014d\u0001\u0000\u0000\u0000\u0152\u014e"+
		"\u0001\u0000\u0000\u0000\u0152\u014f\u0001\u0000\u0000\u0000\u0152\u0150"+
		"\u0001\u0000\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u01537\u0001"+
		"\u0000\u0000\u0000\u0154\u0155\u0005\u001c\u0000\u0000\u0155\u015a\u0003"+
		"\"\u0011\u0000\u0156\u0157\u0005\u0011\u0000\u0000\u0157\u0159\u0003\""+
		"\u0011\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u015c\u0001\u0000"+
		"\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000"+
		"\u0000\u0000\u015d\u015e\u0005\u001d\u0000\u0000\u015e9\u0001\u0000\u0000"+
		"\u0000\">@MWainwz\u0081\u0094\u0098\u00a2\u00ae\u00b4\u00bf\u00ca\u00d1"+
		"\u00d9\u00dd\u00e6\u00e9\u00f1\u010c\u0114\u011c\u0124\u012c\u0134\u013a"+
		"\u0141\u014b\u0152\u015a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}