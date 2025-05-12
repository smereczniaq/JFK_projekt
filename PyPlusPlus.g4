grammar PyPlusPlus;

prog: (statement | function_definition)* EOF;

function_definition: 'fun' (ARROW type)? IDENTIFIER '(' (IDENTIFIER (',' IDENTIFIER)*)? ')' '{' statement* '}';

statement
    : while_loop
    | for_loop
    | if_statement
    | variable_instantiation
    | list_declaration
    | value_assignment
    | expression ';'
    | return_statement
    | 'break' ';'
    | 'continue' ';'
    ;

return_statement: 'return' expression? ';';

while_loop: 'while' expression '{' statement* '}';

for_loop: 'for' IDENTIFIER 'in' (IDENTIFIER | function_call | STRING | literal_list) '{' statement* '}';

if_statement: 'if' expression '{' statement* '}' ( 'else' 'if' expression '{' statement* '}' )* ( 'else' '{' statement* '}' )?;

function_call: IDENTIFIER '(' (expression (',' expression)*)? ')';

variable_instantiation: 'var' IDENTIFIER ('=' expression)? ';';

list_declaration: 'list' IDENTIFIER '=' literal_list ';';

list_access: IDENTIFIER '[' expression ']';

value_assignment: expression '=' expression ';';

expression : logicalOrExpr;
logicalOrExpr: xorExpr ('||' xorExpr)*;
xorExpr: logicalAndExpr ('#' logicalAndExpr)*;
logicalAndExpr: comparisonExpr ('&&' comparisonExpr)*;
comparisonExpr: addExpr (('==' | '!=' | '<' | '>' | '<=' | '>=') addExpr)*;
addExpr: mulExpr (('+' | '-') mulExpr)*;
mulExpr: powExpr (('*' | '/') powExpr)*;
powExpr: unaryExpr ('^' powExpr)?;
unaryExpr: '-' unaryExpr
         | '!' unaryExpr
         | primary;

primary
    : '(' expression ')'
    | list_access
    | function_call
    | literal
    | IDENTIFIER
    ;

literal: INTEGER | FLOAT | STRING | BOOL | literal_list;

type: 'int' | 'double' | 'float' | 'Float32' | 'Float64' | 'string' | 'bool' | 'list';

literal_list: '[' expression (',' expression)* ']';

ARROW: '->';
IDENTIFIER: [_]? LETTER (LETTER | DIGIT | '_')*;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment NON_ZERO_DIGIT: [1-9];
fragment ESC: '\\' .;

INTEGER: NON_ZERO_DIGIT DIGIT* | '0';
FLOAT: (NON_ZERO_DIGIT DIGIT* | '0') '.' DIGIT+;

STRING: '"' (ESC | ~["\\\r\n])* '"';
BOOL: 'True' | 'False';

WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;