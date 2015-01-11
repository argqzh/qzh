Ext.define("core.cbf.view.CbfForm", {
  extend: "Ext.form.Panel",
  alias: "widget.cbfform",
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
      allowBlank: true,
      blankText: '必须在右侧选择村级以下区域',
      readOnly: true
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
      fieldLabel: "承包方编码",
      name: "cbfbm",
      allowBlank: false,
      blankText: '承包方编码不能为空'
    }, {
      xtype: "combobox",
      fieldLabel: "承包方类型",
      name: "cbflx",
      store: "core.combobox.store.CbflxdmbStore",
      displayField: 'cbflx',
      valueField: 'dm',
      allowBlank: true,
      blankText: '承包方类型不能为空',
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "承包方名称",
      name: "cbfmc",
      allowBlank: false,
      blankText: '承包方名称不能为空',
      readOnly: false
    }, {
      xtype: "combobox",
      fieldLabel: "承包方证件类型",
      name: "cbfzjlx",
      store: "core.combobox.store.ZjlxdmbStore",
      displayField: 'zjlx',
      valueField: 'dm',
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "承包方证件号码",
      name: "cbfzjhm",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "承包方地址",
      name: "cbfdz",
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
      fieldLabel: "联系电话",
      name: "lxdh",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "承包方成员数量",
      name: "cbfcysl",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "承包方调查日期",
      name: "cbfdcrq",
      allowBlank: true,
      readOnly: false
    }, {
      colspan: 2,
      xtype: "textfield",
      fieldLabel: "承包方调查员",
      name: "cbfdcy",
      allowBlank: true,
      readOnly: false
    }, {
      colspan: 2,
      width: 430,
      xtype: "textfield",
      fieldLabel: "承包方调查记事",
      name: "cbfdcjs",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "公示记事",
      name: "gsjs",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "公示记事人",
      name: "gsjsr",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "公示审核日期",
      name: "gsshrq",
      allowBlank: true,
      readOnly: false
    }, {
      xtype: "textfield",
      fieldLabel: "公示审核人",
      name: "gsshr",
      allowBlank: true,
      readOnly: false
    }]
});