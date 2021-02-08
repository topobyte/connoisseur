// Copyright 2021 Sebastian Kuerten
//
// This file is part of connoisseur.
//
// connoisseur is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// connoisseur is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with connoisseur. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.maven.core;

import java.util.ArrayList;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

public class SetOfArtifacts
{

	private SetMultimap<UnversionedArtifact, String> artifacts = HashMultimap
			.create();

	public boolean add(VersionedArtifact artifact)
	{
		UnversionedArtifact unversioned = artifact.unversioned();
		return artifacts.put(unversioned, artifact.getVersion());
	}

	public boolean contains(VersionedArtifact artifact)
	{
		return artifacts.containsEntry(artifact.unversioned(),
				artifact.getVersion());
	}

	public ArtifactWithVersions get(UnversionedArtifact unversioned)
	{
		Set<String> versions = artifacts.get(unversioned);
		return new ArtifactWithVersions(unversioned, new ArrayList<>(versions));
	}

	public Set<UnversionedArtifact> getArtifacts()
	{
		return artifacts.keySet();
	}

}
