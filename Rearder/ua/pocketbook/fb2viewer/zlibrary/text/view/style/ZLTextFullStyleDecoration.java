/*
 * Copyright (C) 2007-2010 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package ua.pocketbook.fb2viewer.zlibrary.text.view.style;



import ua.pocketbook.fb2viewer.zlibrary.core.options.*;
import ua.pocketbook.fb2viewer.zlibrary.core.util.*;
import ua.pocketbook.fb2viewer.zlibrary.text.model.ZLTextAlignmentType;
import ua.pocketbook.fb2viewer.zlibrary.text.view.ZLTextHyperlink;
import ua.pocketbook.fb2viewer.zlibrary.text.view.ZLTextStyle;

public class ZLTextFullStyleDecoration extends ZLTextStyleDecoration {
	public final ZLIntegerRangeOption SpaceBeforeOption;
	public final ZLIntegerRangeOption SpaceAfterOption;
	public final ZLIntegerRangeOption LeftIndentOption;
	public final ZLIntegerRangeOption RightIndentOption;
	public final ZLIntegerRangeOption FirstLineIndentDeltaOption;

	public final ZLIntegerOption AlignmentOption;

	public final ZLIntegerOption LineSpacePercentOption;

	public ZLTextFullStyleDecoration(String name, int fontSizeDelta, int bold, int italic, int underline, int spaceBefore, int spaceAfter, int leftIndent,int rightIndent, int firstLineIndentDelta, int verticalShift, byte alignment, int lineSpace, int allowHyphenations) {
		super(name, fontSizeDelta, bold, italic, underline, verticalShift, allowHyphenations);
		SpaceBeforeOption = new ZLIntegerRangeOption(STYLE, name + ":spaceBefore", -10, 100, spaceBefore);
		SpaceAfterOption = new ZLIntegerRangeOption(STYLE, name + ":spaceAfter", -10, 100, spaceAfter);
		LeftIndentOption = new ZLIntegerRangeOption(STYLE, name + ":leftIndent", -300, 300, leftIndent);
		RightIndentOption = new ZLIntegerRangeOption(STYLE, name + ":rightIndent", -300, 300, rightIndent);
		FirstLineIndentDeltaOption = new ZLIntegerRangeOption(STYLE, name + ":firstLineIndentDelta", -300, 300, firstLineIndentDelta);
		AlignmentOption = new ZLIntegerOption(STYLE, name + ":alignment", alignment);
		LineSpacePercentOption = new ZLIntegerOption(STYLE, name + ":lineSpacePercent", lineSpace);
	}

	public boolean isFullDecoration() {
		return true;
	}

	public ZLTextStyle createDecoratedStyle(ZLTextStyle base, ZLTextHyperlink hyperlink) {
		return new ZLTextFullDecoratedStyle(base, this, hyperlink);
	}
}
