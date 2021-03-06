/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2002 International Business Machines Corp. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.ts.tests.jaxrpc.ee.w2j.document.literal.stockquote;

import com.sun.ts.lib.util.*;
import com.sun.ts.lib.porting.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Service Implementation Class - as outlined in JAX-RPC Specification

public class StockQuotePortTypeImpl implements StockQuotePortType {

  private static final float stockPrices[] = { -1.0f, 24.25f, 45.5f };

  private static final String STOCKSYMBOL1 = "GTE";

  private static final String STOCKSYMBOL2 = "GE";

  public float getLastTradePrice(String tickerSymbol) throws RemoteException {
    if (tickerSymbol.equals(STOCKSYMBOL1))
      return stockPrices[1];
    else if (tickerSymbol.equals(STOCKSYMBOL2))
      return stockPrices[2];
    else
      return stockPrices[0];
  }
}
