/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "X",false)
			}),
			new NOT(
				new ModuleFormula("ei",
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "Y",false),
						new Variable(Type.STRING, "X")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			)
		));
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "X",false)
			}),
			new Comparison("==",
				new Variable(Type.STRING, "X"),
				Primitive.newPrimitive("table")
			)
		));
		addRule(new Rule(
			"Main", new int[] {13,9,13,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {13,27,29,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {14,8,14,52},
						new Predicate("launch", new Term[] {
							Primitive.newPrimitive("hw"),
							Primitive.newPrimitive("dependency/tower-1.3.0.jar")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).launch(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {15,8,15,17},
						new Predicate("init", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).init(
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {16,8,16,17},
						new Predicate("join", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).join(
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {17,8,17,26},
						new Predicate("link", new Term[] {
							Primitive.newPrimitive("gripper")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {18,8,18,21},
						new Predicate("startEnv", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).startEnv(
								);
							}
						}
					),
					new ModuleCall("C",
						"Main", new int[] {20,8,20,40},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("waiting for block d")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Wait(
						"Main", new int[] {21,8,29,5},
						new ModuleFormula("ei",
							new Predicate("block", new Term[] {
								Primitive.newPrimitive("d")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Declaration(
						new Variable(Type.LIST, "L"),
						"Main", new int[] {23,8,29,5},
						new ListTerm(new Term[] {
							Primitive.newPrimitive("a"),
							Primitive.newPrimitive("b")
						})
					),
					new Subgoal(
						"Main", new int[] {24,8,29,5},
						new Goal(
							new Predicate("tower", new Term[] {
								new Variable(Type.LIST, "L")
							})
						)
					),
					new Declaration(
						new Variable(Type.LIST, "L2"),
						"Main", new int[] {25,8,29,5},
						new ListTerm(new Term[] {
							Primitive.newPrimitive("b"),
							Primitive.newPrimitive("a"),
							Primitive.newPrimitive("d")
						})
					),
					new Subgoal(
						"Main", new int[] {26,8,29,5},
						new Goal(
							new Predicate("tower", new Term[] {
								new Variable(Type.LIST, "L2")
							})
						)
					),
					new Declaration(
						new Variable(Type.LIST, "L3"),
						"Main", new int[] {27,8,29,5},
						new ListTerm(new Term[] {
							Primitive.newPrimitive("f"),
							Primitive.newPrimitive("a"),
							Primitive.newPrimitive("d"),
							Primitive.newPrimitive("e")
						})
					),
					new Subgoal(
						"Main", new int[] {28,8,29,5},
						new Goal(
							new Predicate("tower", new Term[] {
								new Variable(Type.LIST, "L3")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {31,9,31,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("tower", new Term[] {
						new Variable(Type.LIST, "L",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {31,25,43,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Main", new int[] {32,8,43,5},
						Operator.newOperator('-',
							new Count(
								new Variable(Type.LIST, "L")
							),
							Primitive.newPrimitive(1)
						)
					),
					new Subgoal(
						"Main", new int[] {34,8,43,5},
						new Goal(
							new Predicate("holding", new Term[] {
								new AtIndex(
									new Variable(Type.LIST, "L"),
									new Variable(Type.INTEGER, "i"),
									Type.STRING
								)
							})
						)
					),
					new Subgoal(
						"Main", new int[] {35,8,43,5},
						new Goal(
							new Predicate("on", new Term[] {
								new AtIndex(
									new Variable(Type.LIST, "L"),
									new Variable(Type.INTEGER, "i"),
									Type.STRING
								),
								Primitive.newPrimitive("table")
							})
						)
					),
					new MinusMinus(
						new Variable(Type.INTEGER, "i"),
						"Main", new int[] {36,8,36,11}
					),
					new While(
						"Main", new int[] {38,8,43,5},
						new Comparison(">=",
							new Variable(Type.INTEGER, "i"),
							Primitive.newPrimitive(0)
						),
						new Block(
							"Main", new int[] {38,21,42,9},
							new Statement[] {
								new Subgoal(
									"Main", new int[] {39,11,42,9},
									new Goal(
										new Predicate("holding", new Term[] {
											new AtIndex(
												new Variable(Type.LIST, "L"),
												new Variable(Type.INTEGER, "i"),
												Type.STRING
											)
										})
									)
								),
								new Subgoal(
									"Main", new int[] {40,11,42,9},
									new Goal(
										new Predicate("on", new Term[] {
											new AtIndex(
												new Variable(Type.LIST, "L"),
												new Variable(Type.INTEGER, "i"),
												Type.STRING
											),
											new AtIndex(
												new Variable(Type.LIST, "L"),
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "i"),
													Primitive.newPrimitive(1)
												),
												Type.STRING
											)
										})
									)
								),
								new MinusMinus(
									new Variable(Type.INTEGER, "i"),
									"Main", new int[] {41,11,41,14}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {45,9,45,74},
			new GoalEvent('+',
				new Goal(
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new AND(
				new NOT(
					new ModuleFormula("ei",
						new Predicate("holding", new Term[] {
							new Variable(Type.STRING, "Y",false)
						}),
						new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
							}
						}
					)
				),
				new Predicate("free", new Term[] {
					new Variable(Type.STRING, "target")
				})
			),
			new Block(
				"Main", new int[] {45,73,48,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {46,8,46,25},
						new Predicate("pickup", new Term[] {
							new Variable(Type.STRING, "target")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"Main", new int[] {47,8,48,5},
						new ModuleFormula("ei",
							new Predicate("holding", new Term[] {
								new Variable(Type.STRING, "target")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {50,9,50,85},
			new GoalEvent('+',
				new Goal(
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new AND(
				new NOT(
					new ModuleFormula("ei",
						new Predicate("holding", new Term[] {
							new Variable(Type.STRING, "Y",false)
						}),
						new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
							}
						}
					)
				),
				new ModuleFormula("ei",
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "X",false),
						new Variable(Type.STRING, "target")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			),
			new Block(
				"Main", new int[] {50,84,54,9},
				new Statement[] {
					new Subgoal(
						"Main", new int[] {51,12,54,9},
						new Goal(
							new Predicate("destack", new Term[] {
								new Variable(Type.STRING, "X")
							})
						)
					),
					new ModuleCall("ei",
						"Main", new int[] {52,12,52,29},
						new Predicate("pickup", new Term[] {
							new Variable(Type.STRING, "target")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"Main", new int[] {53,12,54,9},
						new ModuleFormula("ei",
							new Predicate("holding", new Term[] {
								new Variable(Type.STRING, "target")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {56,9,56,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("destack", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "target")
			}),
			new Block(
				"Main", new int[] {56,49,58,5},
				new Statement[] {
					new Subgoal(
						"Main", new int[] {57,8,58,5},
						new Goal(
							new Predicate("holding", new Term[] {
								new Variable(Type.STRING, "target")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {57,25,58,5},
						new Goal(
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "target"),
								Primitive.newPrimitive("table")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {60,9,60,61},
			new GoalEvent('+',
				new Goal(
					new Predicate("destack", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("on", new Term[] {
					new Variable(Type.STRING, "Y",false),
					new Variable(Type.STRING, "target")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Main", new int[] {60,60,63,9},
				new Statement[] {
					new Subgoal(
						"Main", new int[] {61,13,63,9},
						new Goal(
							new Predicate("destack", new Term[] {
								new Variable(Type.STRING, "Y")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {62,13,63,9},
						new Goal(
							new Predicate("destack", new Term[] {
								new Variable(Type.STRING, "target")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {66,9,66,79},
			new GoalEvent('+',
				new Goal(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "block",false),
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "block")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					new Variable(Type.STRING, "target")
				})
			),
			new Block(
				"Main", new int[] {66,78,69,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {67,8,67,33},
						new Predicate("putdown", new Term[] {
							new Variable(Type.STRING, "block"),
							new Variable(Type.STRING, "target")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"Main", new int[] {68,8,69,5},
						new ModuleFormula("ei",
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "block"),
								new Variable(Type.STRING, "target")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EIS) agent.getModule("Main","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("S",astra.lang.System.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Main().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
