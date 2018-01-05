/*******************************************************************************
 * Copyright (c) 2009, 2018 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Evgeny Mandrikov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.test.validation;

/**
 * Provides ability to detect compiler based on difference in generated bytecode
 * for switch by enum.
 */
enum Compiler {

	DETECT;

	/**
	 * @return <code>true</code> if this file was compiled by javac
	 */
	boolean isJDK() {
		switch (DETECT) {
		default:
			try {
				Compiler.class.getDeclaredField("$SWITCH_TABLE$"
						+ Compiler.class.getName().replace('.', '$'));
				return false;
			} catch (NoSuchFieldException e) {
				return true;
			}
		}
	}

}
