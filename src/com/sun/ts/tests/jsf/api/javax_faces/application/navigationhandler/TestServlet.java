/*
 * Copyright (c) 2011, 2018 Oracle and/or its affiliates. All rights reserved.
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

/*
 * $Id$
 */
package com.sun.ts.tests.jsf.api.javax_faces.application.navigationhandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.ts.tests.jsf.common.servlets.HttpTCKServlet;
import com.sun.ts.tests.jsf.common.util.JSFTestUtil;

public class TestServlet extends HttpTCKServlet {

  // Test for HandleNavigationCase(FacesContext, String, String) throws
  // NullPointerException
  public void navigationHandlerHandleNavigationCaseNPETest(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    Application application = getApplication();

    if (application == null) {
      out.println(JSFTestUtil.APP_NULL_MSG);
      return;
    }

    NavigationHandler nh = application.getNavigationHandler();

    JSFTestUtil.checkForNPE(nh, "handleNavigation",
        new Class<?>[] { FacesContext.class, String.class, String.class },
        new Object[] { null, "#{bogus.postOne}", "" }, out);

  }// End navigationHandlerHandleNavigationCaseNPETest

}
