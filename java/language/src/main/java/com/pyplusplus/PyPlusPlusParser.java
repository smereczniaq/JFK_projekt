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
		T__38=39, T__39=40, T__40=41, T__41=42, ARROW=43, IDENTIFIER=44, INTEGER=45, 
		FLOAT=46, STRING=47, BOOL=48, WS=49, COMMENT=50;
	public static final int
		RULE_prog = 0, RULE_function_definition = 1, RULE_statement = 2, RULE_return_statement = 3, 
		RULE_while_loop = 4, RULE_for_loop = 5, RULE_if_statement = 6, RULE_function_call = 7, 
		RULE_variable_instantiation = 8, RULE_list_declaration = 9, RULE_list_access = 10, 
		RULE_value_assignment = 11, RULE_expression = 12, RULE_literal = 13, RULE_type = 14, 
		RULE_literal_list = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "function_definition", "statement", "return_statement", "while_loop", 
			"for_loop", "if_statement", "function_call", "variable_instantiation", 
			"list_declaration", "list_access", "value_assignment", "expression", 
			"literal", "type", "literal_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fun'", "'('", "','", "')'", "'{'", "'}'", "';'", "'break'", "'continue'", 
			"'return'", "'while'", "'for'", "'in'", "'if'", "'else if'", "'else'", 
			"'var'", "'='", "'['", "']'", "'||'", "'#'", "'&&'", "'=='", "'!='", 
			"'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'^'", "'!'", 
			"'int'", "'float'", "'Float32'", "'Float64'", "'string'", "'bool'", "'list'", 
			"'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "ARROW", "IDENTIFIER", "INTEGER", 
			"FLOAT", "STRING", "BOOL", "WS", "COMMENT"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
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
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794950L) != 0)) {
				{
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__13:
				case T__16:
				case T__18:
				case T__34:
				case IDENTIFIER:
				case INTEGER:
				case FLOAT:
				case STRING:
				case BOOL:
					{
					setState(32);
					statement();
					}
					break;
				case T__0:
					{
					setState(33);
					function_definition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(42);
				match(ARROW);
				setState(43);
				type();
				}
			}

			setState(46);
			match(IDENTIFIER);
			setState(47);
			match(T__1);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(48);
				match(IDENTIFIER);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(49);
					match(T__2);
					setState(50);
					match(IDENTIFIER);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(58);
			match(T__3);
			setState(59);
			match(T__4);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794948L) != 0)) {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(T__5);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				while_loop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				for_loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				if_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				variable_instantiation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				list_declaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				value_assignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(74);
				expression(0);
				setState(75);
				match(T__6);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(77);
				return_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(78);
				match(T__7);
				setState(79);
				match(T__6);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(80);
				match(T__8);
				setState(81);
				match(T__6);
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
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__9);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127639556L) != 0)) {
				{
				setState(85);
				expression(0);
				}
			}

			setState(88);
			match(T__6);
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
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_while_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__10);
			setState(91);
			expression(0);
			setState(92);
			match(T__4);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794948L) != 0)) {
				{
				{
				setState(93);
				statement();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(T__5);
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
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_for_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__11);
			setState(102);
			match(IDENTIFIER);
			setState(103);
			match(T__12);
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(104);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(105);
				function_call();
				}
				break;
			case 3:
				{
				setState(106);
				match(STRING);
				}
				break;
			case 4:
				{
				setState(107);
				literal_list();
				}
				break;
			}
			setState(110);
			match(T__4);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794948L) != 0)) {
				{
				{
				setState(111);
				statement();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__5);
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
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__13);
			setState(120);
			expression(0);
			setState(121);
			match(T__4);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794948L) != 0)) {
				{
				{
				setState(122);
				statement();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__5);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(129);
				match(T__14);
				setState(130);
				expression(0);
				setState(131);
				match(T__4);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794948L) != 0)) {
					{
					{
					setState(132);
					statement();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(T__5);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(145);
				match(T__15);
				setState(146);
				match(T__4);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127794948L) != 0)) {
					{
					{
					setState(147);
					statement();
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				match(T__5);
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
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(IDENTIFIER);
			setState(157);
			match(T__1);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545392127639556L) != 0)) {
				{
				setState(158);
				expression(0);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(159);
					match(T__2);
					setState(160);
					expression(0);
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(168);
			match(T__3);
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
	}

	public final Variable_instantiationContext variable_instantiation() throws RecognitionException {
		Variable_instantiationContext _localctx = new Variable_instantiationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable_instantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__16);
			setState(171);
			match(IDENTIFIER);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(172);
				match(T__17);
				setState(173);
				expression(0);
				}
			}

			setState(176);
			match(T__6);
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
	}

	public final List_declarationContext list_declaration() throws RecognitionException {
		List_declarationContext _localctx = new List_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_list_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__16);
			setState(179);
			match(IDENTIFIER);
			setState(180);
			match(T__17);
			setState(181);
			literal_list();
			setState(182);
			match(T__6);
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
	}

	public final List_accessContext list_access() throws RecognitionException {
		List_accessContext _localctx = new List_accessContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_list_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(IDENTIFIER);
			setState(185);
			match(T__18);
			setState(186);
			expression(0);
			setState(187);
			match(T__19);
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
	}

	public final Value_assignmentContext value_assignment() throws RecognitionException {
		Value_assignmentContext _localctx = new Value_assignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_value_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			expression(0);
			setState(190);
			match(T__17);
			setState(191);
			expression(0);
			setState(192);
			match(T__6);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListAccessExprContext extends ExpressionContext {
		public List_accessContext list_access() {
			return getRuleContext(List_accessContext.class,0);
		}
		public ListAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterListAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitListAccessExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalAndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLogicalAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLogicalAndExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterComparisonExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitComparisonExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParensExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitParensExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XorExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public XorExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterXorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitXorExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLogicalOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLogicalOrExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitNotExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitAddExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExprContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitLiteralExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExpressionContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitFunctionCallExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MulExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitMulExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitPowExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(PyPlusPlusParser.IDENTIFIER, 0); }
		public IdentifierExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyPlusPlusListener ) ((PyPlusPlusListener)listener).exitIdentifierExpr(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(195);
				match(T__34);
				setState(196);
				expression(6);
				}
				break;
			case 2:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(T__1);
				setState(198);
				expression(0);
				setState(199);
				match(T__3);
				}
				break;
			case 3:
				{
				_localctx = new ListAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				list_access();
				}
				break;
			case 4:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				function_call();
				}
				break;
			case 5:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				literal();
				}
				break;
			case 6:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(IDENTIFIER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalOrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(208);
						match(T__20);
						setState(209);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new XorExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(211);
						match(T__21);
						setState(212);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new LogicalAndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(214);
						match(T__22);
						setState(215);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(217);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1056964608L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(220);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new MulExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(223);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(226);
						match(T__33);
						setState(227);
						expression(8);
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(FLOAT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(STRING);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
				match(BOOL);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
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
	public static class TypeContext extends ParserRuleContext {
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8727373545472L) != 0)) ) {
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
	}

	public final Literal_listContext literal_list() throws RecognitionException {
		Literal_listContext _localctx = new Literal_listContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_literal_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__18);
			setState(243);
			expression(0);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(244);
				match(T__2);
				setState(245);
				expression(0);
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
			match(T__19);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00012\u00fe\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"-\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0003\u00019\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001>\b\u0001\n\u0001\f\u0001A\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002S\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0003\u0003W\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004_\b"+
		"\u0004\n\u0004\f\u0004b\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005m\b\u0005\u0001\u0005\u0001\u0005\u0005\u0005q\b\u0005\n\u0005\f"+
		"\u0005t\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006|\b\u0006\n\u0006\f\u0006\u007f\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u0086\b\u0006\n\u0006\f\u0006\u0089\t\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u008d\b\u0006\n\u0006\f\u0006\u0090\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0095\b\u0006\n\u0006\f\u0006\u0098\t\u0006\u0001"+
		"\u0006\u0003\u0006\u009b\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u00a2\b\u0007\n\u0007\f\u0007\u00a5\t\u0007"+
		"\u0003\u0007\u00a7\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00af\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00ce\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00e5\b\f\n\f\f\f\u00e8\t\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ef\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00f7\b\u000f\n\u000f\f\u000f\u00fa\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0000\u0001\u0018\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000\u0018"+
		"\u001d\u0001\u0000\u001e\u001f\u0001\u0000 !\u0001\u0000$*\u011b\u0000"+
		"$\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0004R\u0001"+
		"\u0000\u0000\u0000\u0006T\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000"+
		"\u0000\ne\u0001\u0000\u0000\u0000\fw\u0001\u0000\u0000\u0000\u000e\u009c"+
		"\u0001\u0000\u0000\u0000\u0010\u00aa\u0001\u0000\u0000\u0000\u0012\u00b2"+
		"\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000\u0000\u0016\u00bd"+
		"\u0001\u0000\u0000\u0000\u0018\u00cd\u0001\u0000\u0000\u0000\u001a\u00ee"+
		"\u0001\u0000\u0000\u0000\u001c\u00f0\u0001\u0000\u0000\u0000\u001e\u00f2"+
		"\u0001\u0000\u0000\u0000 #\u0003\u0004\u0002\u0000!#\u0003\u0002\u0001"+
		"\u0000\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000"+
		"\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0005\u0000\u0000\u0001"+
		"(\u0001\u0001\u0000\u0000\u0000),\u0005\u0001\u0000\u0000*+\u0005+\u0000"+
		"\u0000+-\u0003\u001c\u000e\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0005,\u0000\u0000/8\u0005\u0002"+
		"\u0000\u000005\u0005,\u0000\u000012\u0005\u0003\u0000\u000024\u0005,\u0000"+
		"\u000031\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000080\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:;\u0005\u0004\u0000\u0000;?\u0005\u0005\u0000"+
		"\u0000<>\u0003\u0004\u0002\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0006\u0000\u0000"+
		"C\u0003\u0001\u0000\u0000\u0000DS\u0003\b\u0004\u0000ES\u0003\n\u0005"+
		"\u0000FS\u0003\f\u0006\u0000GS\u0003\u0010\b\u0000HS\u0003\u0012\t\u0000"+
		"IS\u0003\u0016\u000b\u0000JK\u0003\u0018\f\u0000KL\u0005\u0007\u0000\u0000"+
		"LS\u0001\u0000\u0000\u0000MS\u0003\u0006\u0003\u0000NO\u0005\b\u0000\u0000"+
		"OS\u0005\u0007\u0000\u0000PQ\u0005\t\u0000\u0000QS\u0005\u0007\u0000\u0000"+
		"RD\u0001\u0000\u0000\u0000RE\u0001\u0000\u0000\u0000RF\u0001\u0000\u0000"+
		"\u0000RG\u0001\u0000\u0000\u0000RH\u0001\u0000\u0000\u0000RI\u0001\u0000"+
		"\u0000\u0000RJ\u0001\u0000\u0000\u0000RM\u0001\u0000\u0000\u0000RN\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000S\u0005\u0001\u0000\u0000"+
		"\u0000TV\u0005\n\u0000\u0000UW\u0003\u0018\f\u0000VU\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005\u0007"+
		"\u0000\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0005\u000b\u0000\u0000"+
		"[\\\u0003\u0018\f\u0000\\`\u0005\u0005\u0000\u0000]_\u0003\u0004\u0002"+
		"\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000b`\u0001"+
		"\u0000\u0000\u0000cd\u0005\u0006\u0000\u0000d\t\u0001\u0000\u0000\u0000"+
		"ef\u0005\f\u0000\u0000fg\u0005,\u0000\u0000gl\u0005\r\u0000\u0000hm\u0005"+
		",\u0000\u0000im\u0003\u000e\u0007\u0000jm\u0005/\u0000\u0000km\u0003\u001e"+
		"\u000f\u0000lh\u0001\u0000\u0000\u0000li\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"nr\u0005\u0005\u0000\u0000oq\u0003\u0004\u0002\u0000po\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005"+
		"\u0006\u0000\u0000v\u000b\u0001\u0000\u0000\u0000wx\u0005\u000e\u0000"+
		"\u0000xy\u0003\u0018\f\u0000y}\u0005\u0005\u0000\u0000z|\u0003\u0004\u0002"+
		"\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u008e\u0005\u0006\u0000\u0000"+
		"\u0081\u0082\u0005\u000f\u0000\u0000\u0082\u0083\u0003\u0018\f\u0000\u0083"+
		"\u0087\u0005\u0005\u0000\u0000\u0084\u0086\u0003\u0004\u0002\u0000\u0085"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005\u0006\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c"+
		"\u0081\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u009a\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005\u0010\u0000\u0000\u0092\u0096\u0005\u0005\u0000\u0000\u0093"+
		"\u0095\u0003\u0004\u0002\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0099\u009b\u0005\u0006\u0000\u0000\u009a"+
		"\u0091\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"+
		"\r\u0001\u0000\u0000\u0000\u009c\u009d\u0005,\u0000\u0000\u009d\u00a6"+
		"\u0005\u0002\u0000\u0000\u009e\u00a3\u0003\u0018\f\u0000\u009f\u00a0\u0005"+
		"\u0003\u0000\u0000\u00a0\u00a2\u0003\u0018\f\u0000\u00a1\u009f\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u009e\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005\u0004\u0000\u0000\u00a9\u000f\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005\u0011\u0000\u0000\u00ab\u00ae\u0005,\u0000"+
		"\u0000\u00ac\u00ad\u0005\u0012\u0000\u0000\u00ad\u00af\u0003\u0018\f\u0000"+
		"\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0007\u0000\u0000"+
		"\u00b1\u0011\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0011\u0000\u0000"+
		"\u00b3\u00b4\u0005,\u0000\u0000\u00b4\u00b5\u0005\u0012\u0000\u0000\u00b5"+
		"\u00b6\u0003\u001e\u000f\u0000\u00b6\u00b7\u0005\u0007\u0000\u0000\u00b7"+
		"\u0013\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005,\u0000\u0000\u00b9\u00ba"+
		"\u0005\u0013\u0000\u0000\u00ba\u00bb\u0003\u0018\f\u0000\u00bb\u00bc\u0005"+
		"\u0014\u0000\u0000\u00bc\u0015\u0001\u0000\u0000\u0000\u00bd\u00be\u0003"+
		"\u0018\f\u0000\u00be\u00bf\u0005\u0012\u0000\u0000\u00bf\u00c0\u0003\u0018"+
		"\f\u0000\u00c0\u00c1\u0005\u0007\u0000\u0000\u00c1\u0017\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0006\f\uffff\uffff\u0000\u00c3\u00c4\u0005#\u0000"+
		"\u0000\u00c4\u00ce\u0003\u0018\f\u0006\u00c5\u00c6\u0005\u0002\u0000\u0000"+
		"\u00c6\u00c7\u0003\u0018\f\u0000\u00c7\u00c8\u0005\u0004\u0000\u0000\u00c8"+
		"\u00ce\u0001\u0000\u0000\u0000\u00c9\u00ce\u0003\u0014\n\u0000\u00ca\u00ce"+
		"\u0003\u000e\u0007\u0000\u00cb\u00ce\u0003\u001a\r\u0000\u00cc\u00ce\u0005"+
		",\u0000\u0000\u00cd\u00c2\u0001\u0000\u0000\u0000\u00cd\u00c5\u0001\u0000"+
		"\u0000\u0000\u00cd\u00c9\u0001\u0000\u0000\u0000\u00cd\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00e6\u0001\u0000\u0000\u0000\u00cf\u00d0\n\r\u0000"+
		"\u0000\u00d0\u00d1\u0005\u0015\u0000\u0000\u00d1\u00e5\u0003\u0018\f\u000e"+
		"\u00d2\u00d3\n\f\u0000\u0000\u00d3\u00d4\u0005\u0016\u0000\u0000\u00d4"+
		"\u00e5\u0003\u0018\f\r\u00d5\u00d6\n\u000b\u0000\u0000\u00d6\u00d7\u0005"+
		"\u0017\u0000\u0000\u00d7\u00e5\u0003\u0018\f\f\u00d8\u00d9\n\n\u0000\u0000"+
		"\u00d9\u00da\u0007\u0000\u0000\u0000\u00da\u00e5\u0003\u0018\f\u000b\u00db"+
		"\u00dc\n\t\u0000\u0000\u00dc\u00dd\u0007\u0001\u0000\u0000\u00dd\u00e5"+
		"\u0003\u0018\f\n\u00de\u00df\n\b\u0000\u0000\u00df\u00e0\u0007\u0002\u0000"+
		"\u0000\u00e0\u00e5\u0003\u0018\f\t\u00e1\u00e2\n\u0007\u0000\u0000\u00e2"+
		"\u00e3\u0005\"\u0000\u0000\u00e3\u00e5\u0003\u0018\f\b\u00e4\u00cf\u0001"+
		"\u0000\u0000\u0000\u00e4\u00d2\u0001\u0000\u0000\u0000\u00e4\u00d5\u0001"+
		"\u0000\u0000\u0000\u00e4\u00d8\u0001\u0000\u0000\u0000\u00e4\u00db\u0001"+
		"\u0000\u0000\u0000\u00e4\u00de\u0001\u0000\u0000\u0000\u00e4\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u0019\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ef\u0005"+
		"-\u0000\u0000\u00ea\u00ef\u0005.\u0000\u0000\u00eb\u00ef\u0005/\u0000"+
		"\u0000\u00ec\u00ef\u00050\u0000\u0000\u00ed\u00ef\u0003\u001e\u000f\u0000"+
		"\u00ee\u00e9\u0001\u0000\u0000\u0000\u00ee\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ee\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ef\u001b\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0007\u0003\u0000\u0000\u00f1\u001d\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0005\u0013\u0000\u0000\u00f3\u00f8\u0003\u0018\f\u0000\u00f4"+
		"\u00f5\u0005\u0003\u0000\u0000\u00f5\u00f7\u0003\u0018\f\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc"+
		"\u0005\u0014\u0000\u0000\u00fc\u001f\u0001\u0000\u0000\u0000\u0018\"$"+
		",58?RV`lr}\u0087\u008e\u0096\u009a\u00a3\u00a6\u00ae\u00cd\u00e4\u00e6"+
		"\u00ee\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}