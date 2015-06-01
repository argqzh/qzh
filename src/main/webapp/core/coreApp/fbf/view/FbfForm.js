Ext.define("core.fbf.view.FbfForm", {
  extend: "Ext.form.Panel",
  alias: "widget.fbfform",
  align: "left",
  frame: true,
  defaults: {
    margin: "7 0 0 15",
    selectOnFocus: true
  },
  layout: {
    type: "table",
    columns: 2
  },
  tbar: [{
      xtype: "button",
      ref: "save",
      iconCls: 'table_save',
      text: "保存"
    }],
  items: [{
      colspan: 2,
      xtype: "textfield",
      width: 430,
      fieldLabel: "所属区域",
      name: "orgName",
      allowBlank: false,
      blankText: '必须在右侧选择村级以下区域',
      readOnly: true,
      listeners: {
        render: function(component) {
          component.getEl().on('click', function(event, el) {
//            component.setValue("TEXT");
            var win;
            if (!win) {
              win = Ext.create("core.fbf.view.OrgWindowAll_fbf");
            }
            if (win.isVisible()) {
              win.hide();
            } else {
              win.show();
            }
          });
        }
      }
    }, {
      xtype: "textfield",
      fieldLabel: "区域级别",
      name: "isAdd",
      value: "1",
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
      value: "",
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "组织机构id",
      name: "orgId",
      value: "",
      hidden: true
    }, {
      xtype: "textfield",
      fieldLabel: "发包方编码",
      name: "fbfbm",
      allowBlank: false,
      blankText: '发包方编码不能为空'
    }, {
      xtype: "textfield",
      fieldLabel: "发包方名称",
      name: "fbfmc",
      allowBlank: false,
      blankText: '发包方名称不能为空',
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "发包方负责人名称",
      name: "fbffzrxm",
      readOnly: false
    }, {
      xtype: "combobox",
      fieldLabel: "负责人证件类型",
      name: "fzrzjlx",
      store: "core.combobox.store.ZjlxdmbStore",
      displayField: 'zjlx',
      valueField: 'dm',
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "负责人证件号码",
      name: "fzrzjhm",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "联系电话",
      name: "lxdh",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "发包方地址",
      name: "fbfdz",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "邮政编码",
      name: "yzbm",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "发包方调查员",
      name: "fbfdcy",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "datefield",
      fieldLabel: "发包方调查日期",
      name: "fbfdcrq",
      format: 'Y-m-d',
      allowBlank: true,
      readOnly: false
    }, {
      colspan: 2,
      width: 430,
      xtype: "textfield",
      fieldLabel: "发包方调查记事",
      name: "fbfdcjs",
      allowBlank: true,
      readOnly: false
    }]
});