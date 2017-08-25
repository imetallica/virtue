package virtue.compiler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;


public class TokenizerTest {

  @Test
  public void tokenizerParsesTokens() throws Exception {
    String s = "let foo = 1 + 5";
    List<Token> result = new Tokenizer().evaluate(s);
    List<Token> expected = new ArrayList<Token>();

    expected.add(new Token(Token.Kind.KEYWORD, "let"));
    expected.add(new Token(Token.Kind.VALUE, "foo"));
    expected.add(new Token(Token.Kind.OPERATOR, "="));
    expected.add(new Token(Token.Kind.VALUE, "1"));
    expected.add(new Token(Token.Kind.OPERATOR, "+"));
    expected.add(new Token(Token.Kind.VALUE, "5"));
    expected.add(new Token(Token.Kind.EOL));

    Assert.assertEquals(expected, result);
  }

}