/* 
  Copyright (C) Iuri L. Machado. All rights reserved.
*/

package virtue.compiler;

import java.io.Serializable;

class Token implements Serializable {
  public enum Kind {
    TYPE,     // Can be a module or a type. Starts with Uppercase letter. 
    KEYWORD,  // A language reserved keyword.
    OPERATOR, // One of the many supported operators by the language.
    VALUE,    // Anything else.
    EOL
  }

  private final Kind kind;
  private final String value;

  Token(Kind k) {
    this.kind = k;
    this.value = "";
  }

  Token(Kind k, String v) {
    this.kind = k;
    this.value = v;
  }

  public Kind getKind() {
    return this.kind;
  }

  public String getValue() {
    return this.value;
  }

  public String toString() {
    if (this.value == "") 
      return "{ " + this.kind.toString() + " }";  
    else 
      return "{ " + this.kind.toString() + ", " + this.value + " }";
  }
}