Ext.define("core.qzh_cancel.view.QzhCancelForm", {
  extend: 'Ext.form.Panel',
  alias: "widget.qzhCancelForm",
  align: "left",
  id: "qzhCancelFormId",
  labelWidth: 200,
  frame: true,
  defaults: {
    margin: "7 15 0 15",
    selectOnFocus: true
  },
  layout: {
    type: "table",
    columns: 2
  },
  defaultType: 'textfield',
  border: 0,
  items: [{
      colspan: 2,
      xtype: "textfield",
      width: 430,
      fieldLabel: "所属区域",
      name: "orgName",
      allowBlank: true,
      blankText: '必须在右侧选择村级以下区域',
      readOnly: true,
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "区域级别",
      name: "isAdd",
      value: "1",
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "组织机构id",
      name: "orgId",
      value: "0",
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "区域级别",
      name: "orgLevel",
      value: "0",
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "主键",
      name: "id",
      value: 0,
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "承包经营权证（登记簿）编码",
      name: "cbjyqzbm",
      allowBlank: false,
      blankText: '承包经营权证（登记簿）编码不能为空',
      listeners: {
        render: function(component) {
          component.getEl().on('click', function(event, el) {
//            component.setValue("TEXT");
            var cbhtWin;
            if (!cbhtWin) {
              cbhtWin = Ext.create("core.qzh_cancel.view.QzhWindow_get");
            }
            if (cbhtWin.isVisible()) {
              cbhtWin.hide();
            } else {
              cbhtWin.show();
            }
          });
        }
      }
    }, {
      xtype: "datefield",
      fieldLabel: "注销日期",
      name: "zxrq",
      format: 'Y-m-d',
      allowBlank: false,
      readOnly: false
    }, {
      colspan: 2,
      xtype: "textfield",
      width: 430,
      xtype: "textfield",
      fieldLabel: "注销原因",
      name: "zxyy",
      allowBlank: false,
      readOnly: false
    }],
  buttons: [{
      xtype: "button",
      text: '保存',
      ref: "save",
      width: 50
    }, {
      xtype: "button",
      text: '取消',
      width: 50,
      //margin : "10 10 10 20",
      handler: function(_btn) {
        _btn.up('.window').close();
      }
    }]
});