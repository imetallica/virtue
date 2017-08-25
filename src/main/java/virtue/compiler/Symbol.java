/* 
  Copyright (C) Iuri L. Machado. All rights reserved.
*/

package virtue.compiler;

import java.io.Serializable;

/** 
  * A Symbol is the main part for all tokens/symbols used
  * by the language. Probably what you want is to use one
  * of the types provided by Virtue.
*/
public class Symbol implements Serializable {
  static final long serialVersionUID = 0L;

  final String namespace;
  final String name;
  transient String fullName;

  public Symbol(String name) {
    this.name = name;
    this.namespace = null;
  }

  public Symbol(String name, String namespace) {
    this.name = name;
    this.namespace = namespace;
  }

  public String getNamespace() {
    return this.namespace;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    if (this.fullName == null) {
      if (this.namespace != null) {
        this.fullName = this.namespace + "." + this.name;
      } else {
        this.fullName = this.name;
      }
    } 
    
    return this.fullName;
  }
}