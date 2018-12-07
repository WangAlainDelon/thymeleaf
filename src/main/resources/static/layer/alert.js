/**
 * 成功提示信息弹出框
 */
function jSuccess(msg, callback) {
	var al = layer.open({
		icon: 1,
		closeBtn: false,
		title: "成功提示信息",
		content: msg,
		shade: [0.5, '#000', true],
		area: ['310px', 'auto'],
		border: [5, 0.3, '#000', true],
		btn: ['确定'],
		yes: function (res) {
			layer.close(al);
			if (callback) {
				callback(res);
			}
		}
	});
}

/**
 * 失败提示信息弹出框
 */
function jFail(msg, callback) {
	var al = layer.open({
		closeBtn: false,
		title: "失败提示信息",
		shade: [0.5, '#000', true],
		area: ['310px', 'auto'],
		border: [5, 0.3, '#000', true],
		content: msg,
		icon: 2,
		btn: ['确定'],
		yes: function (res) {
			layer.close(al);
			if (callback) {
				callback(res);
			}
		}
	});
}

/**
 * 失败提示信息弹出框
 */
function jFail1(msg, buttonStr, callback) {
	var al = layer.open({
		closeBtn: false,
		title: "失败提示信息",
		shade: [0.5, '#000', true],
		area: ['310px', 'auto'],
		border: [5, 0.3, '#000', true],
		content: msg,
		icon: 2,
		btn: [buttonStr],
		yes: function (res) {
			layer.close(al);
			if (callback) {
				callback(res);
			}
		}
	});
}

/**
 * 警告信息弹出框
 */
function jWarn(msg, callback) {
	var al = layer.open({
		closeBtn: false,
		title: "警告信息",
		shade: [0.5, '#000', true],
		area: ['310px', 'auto'],
		border: [5, 0.3, '#000', true],
		content: msg,
		icon: 0,
		btn: ['确定'],
		yes: function (res) {
			layer.close(al);
			if (callback) {
				callback(res);
			}
		}
	});
}

/**
 *弹出框
 */
function jAlert(successMsg, failMsg, warnMsg, callback) {
	if (successMsg != null && successMsg != '') {
		jSuccess(successMsg, callback);
	} else if (failMsg != null && failMsg != '') {
		jFail(failMsg, callback);
	} else if (warnMsg != null && warnMsg != '') {
		jWarn(warnMsg, callback);
	}
}

/**
 * 确认框
 */
function jConfirm(msg, yesCallback, noCallback) {
	layer.confirm(msg, {
		closeBtn: false,
		title: "确认框",
		shade: [0.5, '#000', true],
		area: ['310px', 'auto'],
		border: [5, 0.3, '#000', true],
		icon: 3,
		btn: ['确定', '取消']
	}, function () {
		if (yesCallback) {
			yesCallback();
		}
	}, function () {
		if (noCallback) {
			noCallback();
		}
	});
}

/**
 * 成功提示信息弹出框
 */
function jSuccessConfirm(msg, yesBtn, noBtn, yesCallback, noCallback) {
	layer.confirm(msg, {
		closeBtn: false,
		title: "成功提示信息",
		shade: [0.5, '#000', true],
		area: ['310px', 'auto'],
		border: [5, 0.3, '#000', true],
		icon: 1,
		btn: [yesBtn, noBtn]
	}, function () {
		if (yesCallback) {
			yesCallback();
		}
	}, function () {
		if (noCallback) {
			noCallback();
		}
	});
}

/**
 * 确认框
 */
function jMoneyBalance(yesCallback, noCallback) {
	var al = layer.open({
		closeBtn: false,
		title: "支付提示信息",
		shade: [0.5, '#000', true],
		area: ['500px', 'auto'],
		border: [5, 0.3, '#000', true],
		content: "请您在新打开的支付页面进行支付，支付完成前请不要关闭该窗口",
		icon: 0,
		btn: ['已完成支付', '选择其他方式支付'],
		yes: function (res) {
			layer.close(al);
			if (yesCallback) {
				yesCallback(res);
			}
		},
		cancel: function (res) {
			if (noCallback) {
				noCallback(res);
			}
			return false;

		}
	});
	return al;
}

function setHeight(msg) {
	if (msg) {
		var line = Math.ceil(msg.replace(/[^\x00-\xff]/g, "00").length / 32);
		$('.xubox_main').height(line * 26 + 100);
	}
	$('.xubox_border').height("auto").width("auto");
}

/**字符串转换*/
function jStrConvert(msg) {
	return $('<div></div>').html(msg).text();
}

/**无符号整数验证*/
function jValidateUnsignedInteger() {
	var str = "";
	if (arguments.length > 0) {
		str = arguments[0];
	}
	var bool = false;
	if (arguments.length > 1) {
		bool = arguments[1];
	}

	if (bool && (!str || str == null || str == "")) {
		return false;
	}

	if (str && str != null && str != "") {
		if (!/^\d*$/.test(str)) {
			return false;
		}
	}
	return true;
}

/**无符号整数验证*/
function jValidateUnsignedLong() {
	var str = "";
	if (arguments.length > 0) {
		str = arguments[0];
	}
	var bool = false;
	if (arguments.length > 1) {
		bool = arguments[1];
	}

	if (bool && (!str || str == null || str == "")) {
		return false;
	}

	if (str && str != null && str != "") {
		if (!/^\d{1,9}$/.test(str)) {
			return false;
		}
	}
	return true;
}

/**
 * 页面元素提示
 * @param $obj    吸附元素
 * @param position    提示位置1上，2右，3下，4左
 * @param content    提示内容
 */
function tips($obj, position, content) {
	layer.tips(content, $obj, {
		tips: [position, '#3595CC'],
		area: ['200px', '120px'],
		time: 4000
	});
}

/**
 * 保留两位小数
 * @param floatvar 待格式化的值
 * @returns {*}
 */
function changeTwoDecimal(floatvar) {
	var f_x = parseFloat(floatvar);
	if (isNaN(f_x)) {
		return '0.00';
	}
	var f_x = Math.round(f_x * 100) / 100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0) {
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2) {
		s_x += '0';
	}
	return s_x;
}