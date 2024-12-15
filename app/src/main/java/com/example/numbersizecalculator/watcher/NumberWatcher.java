package com.example.numbersizecalculator.watcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.numbersizecalculator.util.FormatChecker;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberWatcher implements TextWatcher {

    private TextView bitSize;
    private TextView byteSize;
    private TextView type;

    public NumberWatcher(TextView bitSize, TextView byteSize, TextView type) {
        this.bitSize = bitSize;
        this.byteSize = byteSize;
        this.type = type;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String format = FormatChecker.checkNumberType(s.toString());
        type.setText(format);
        int bitCount;
        int byteCount;
        if (
                format.equals("Byte") ||
                format.equals("Short") ||
                format.equals("Int") ||
                format.equals("Long") ||
                format.equals("BigInteger")
        ) {
            bitCount = new BigInteger(s.toString()).bitLength();
        } else if (
                        format.equals("Float") ||
                        format.equals("Double") ||
                        format.equals("BigDecimal")
        ) {
            bitCount = new BigDecimal(s.toString()).unscaledValue().bitLength();
        } else {
            bitCount = 0;
        }
        if (bitCount != 0) {
            byteCount = (bitCount - 1) / 8 + 1;
        } else {
            byteCount = 0;
        }
        bitSize.setText(Integer.valueOf(bitCount).toString());
        byteSize.setText(Integer.valueOf(byteCount).toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
