package coffeestand;

public enum Type {
	Normal {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Fighting:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			return false;
		}

	},
	Fire {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Water:
				return true;
			case Ground:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Grass:
				return true;
			case Ice:
				return true;
			case Fairy:
				return true;
			default:
				return false;
			}
		}

	},
	Water {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Electric:
				return true;
			case Grass:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Fire:
				return true;
			case Ground:
				return true;
			case Ice:
				return true;
			default:
				return false;
			}
		}

	},
	Electric {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Ground:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Electric:
				return true;
			case Flying:
				return true;
			default:
				return false;
			}
		}

	},
	Ground {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Water:
				return true;
			case Grass:
				return true;
			case Ice:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Poison:
				return true;
			default:
				return false;
			}
		}

	},
	Poision {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Ground:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Fighting:
				return true;
			case Grass:
				return true;
			case Poison:
				return true;
			case Fairy:
				return true;
			default:
				return false;
			}
		}

	},
	Grass {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Fire:
				return true;
			case Ice:
				return true;
			case Poison:
				return true;
			case Flying:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Water:
				return true;
			case Grass:
				return true;
			case Electric:
				return true;
			case Ground:
				return true;
			default:
				return false;
			}
		}

	},
	Flying {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Electric:
				return true;
			case Ice:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Grass:
				return true;
			case Fighting:
				return true;
			default:
				return false;
			}
		}

	},
	Ice {
		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Fire:
				return true;
			case Fighting:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Ice:
				return true;
			default:
				return false;
			}
		}

	},
	Fighting {
		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Flying:
				return true;
			case Fairy:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Ground:
				return true;
			default:
				return false;
			}
		}
	},
	Fairy {
		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Poison:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Fighting:
				return true;
			default:
				return false;
			}
		}
	},
	Poison {
		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Ground:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Grass:
				return true;
			case Fighting:
				return true;
			case Poison:
				return true;
			case Fairy:
				return true;
			default:
				return false;
			}
		}
	};

	/**
	 * <p>
	 * Defines whether the current type is weak to the type specified in variable t
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * <li>If the current type is Fire and the parameter passed is Water, this
	 * method will return true</li>
	 * </p>
	 * 
	 * @param t Type to verify weakness on
	 * @return True if current type is weak to type "t", false otherwise
	 */
	public abstract boolean hasWeakness(Type t);

	/**
	 * <p>
	 * Defines whether the current type has an advantage over the type specified in
	 * variable t
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * <li>If the current type is Fire and the parameter passed is Grass, this
	 * method will return true</li>
	 * </p>
	 * 
	 * @param t Type to verify advantage on
	 * @return True if current type is stronger than type "t", false otherwise
	 */
	public abstract boolean hasStrength(Type t);
}