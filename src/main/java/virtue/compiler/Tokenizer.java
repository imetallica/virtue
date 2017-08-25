/* 
  Copyright (C) Iuri L. Machado. All rights reserved.
*/

package virtue.compiler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import virtue.compiler.Token.Kind;

class Tokenizer {
  public List<Token> evaluate(String line) throws InvalidTokenException {
    List<Token> tokens = new ArrayList<Token>();

    String[] a = line.split("\\s+"); // Split all words and remove all whitespacing.

    for (String value : a) {
      tokens.add(returnToken(value));
    }

    // Finished evaluating line
    tokens.add(new Token(Kind.EOL));

    return tokens;
  }

  private Token returnToken(String value) throws InvalidTokenException {
    if (this.returnKeyword(value).isPresent()) return this.returnKeyword(value).get();
    else if (this.returnOperator(value).isPresent()) return this.returnOperator(value).get();
    else if (this.returnType(value).isPresent()) return this.returnType(value).get();
    else return returnValue(value).get();
  }

  private Optional<Token> returnKeyword(String value) {
    switch (value) {
      case "let":   return Optional.of(new Token(Kind.KEYWORD, "let"));
      default: return Optional.empty();
    }
  }

  private Optional<Token> returnOperator(String value) {
    switch (value) {
      case "=":   return Optional.of(new Token(Kind.OPERATOR, "="));
      case "+":   return Optional.of(new Token(Kind.OPERATOR, "+"));
      default: return Optional.empty();
    }
  }

  private Optional<Token> returnType(String value) {
    return Optional.empty();
  }

  private Optional<Token> returnValue(String value) {
    return Optional.of(new Token(Kind.VALUE, value));
  }

  class InvalidTokenException extends Exception {
    private String message;
    
    InvalidTokenException(String message) {
      this.message = message;
    }
  
    public String getMessage() {
      return this.message;
    }
  }
}