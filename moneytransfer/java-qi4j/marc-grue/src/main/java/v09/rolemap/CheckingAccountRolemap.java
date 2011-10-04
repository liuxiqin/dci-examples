/*
 * Copyright (c) 2010, Rickard Öberg. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package v09.rolemap;

import v09.context.PayBillsContext;
import v09.context.TransferMoneyContext;
import v09.domain.entity.CheckingAccountEntity;

/**
 * You can transfer money to and from a checking account
 */
public interface CheckingAccountRolemap
      extends CheckingAccountEntity,
      // Roles
      TransferMoneyContext.SourceAccountRole,
      TransferMoneyContext.DestinationAccountRole,

      PayBillsContext.SourceAccountRole
{
}
