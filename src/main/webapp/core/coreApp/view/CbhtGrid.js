
Ext.define("core.view.CbhtGrid", {
  extend: "Ext.grid.Panel",
  alias: "widget.cbhtgrid",
  id: "cbhtgrid",
  store: "core.store.CbhtStore",
  border: 0,
  selModel: {
    selType: "checkboxmodel"
  },
  multiSelect: true,
  frame: true,
  tbar: [
    {xtype: 'button', text: '添加', ref: 'add', iconCls: 'table_add'}, '|',
    {xtype: 'button', text: '修改', ref: 'edit', iconCls: 'table_edit'}, '|',
    {xtype: 'button', text: '删除', ref: 'del', iconCls: 'table_remove'},
    "->",
    '按名称查询:',
    {
      xtype: 'triggerfield',
      triggerCls: Ext.baseCSSPrefix + 'form-search-trigger',
      listeners: {
        "change": function(_this, _new, _old, _opt) {
          var _store = _this.ownerCt.ownerCt.getStore();
          _store.clearFilter(false);
          _store.filter("name", _new);
        }
      },
      onTriggerClick: function() {
        var _store = this.ownerCt.ownerCt.getStore();
        _store.clearFilter(false);
        _store.filter("name", this.getValue());
      }
    },
    '按编号查询:',
    {
      xtype: 'triggerfield',
      triggerCls: Ext.baseCSSPrefix + 'form-search-trigger',
      listeners: {
        "change": function(_this, _new, _old, _opt) {
          var _store = _this.ownerCt.ownerCt.getStore();
          _store.clearFilter(false);
          _store.filter("id", _new);
        }
      },
      onTriggerClick: function() {
        var _store = this.ownerCt.ownerCt.getStore();
        _store.clearFilter(false);
        _store.filter("id", this.getValue());
      }
    }
  ],
  bbar: {
    xtype: 'pagingtoolbar',
    store: 'core.store.CbhtStore',
    dock: 'bottom',
    displayInfo: true
  },
  enableKeyNav: true, //可以使用键盘控制上下
  columnLines: true, //展示竖线
  columns: [
    {xtype: 'rownumberer'},
    {text: "地块编码", dataIndex: "cbhtbm", width: 100, field: {
        xtype: "textfield"
      }},
    {text: "地块名称", dataIndex: "cbhtmc", width: 100, field: {
        xtype: "textfield"
      }},
    {text: "地块类别", dataIndex: "cbhtlb", width: 70, field: {
        xtype: "textfield"
      }},
    {text: "土地用途", dataIndex: "tdyt", width: 70, field: {
        xtype: "textfield"
      }},
    {text: "实测面积", dataIndex: "scmj", width: 70, field: {
        xtype: "textfield"
      }},
    {text: "地块东至", dataIndex: "cbhtdz", width: 70, field: {
        xtype: "textfield"
      }},
    {text: "地块西至", dataIndex: "cbhtxz", width: 70, field: {
        xtype: "textfield"
      }},
    {text: "地块南至", dataIndex: "cbhtnz", width: 70, field: {
        xtype: "textfield"
      }},
    {text: "地块北至", dataIndex: "cbhtbz", width: 70, field: {
        xtype: "textfield"
      }}
  ],
  initComponent: function() {
    this.callParent(arguments);
  }
});